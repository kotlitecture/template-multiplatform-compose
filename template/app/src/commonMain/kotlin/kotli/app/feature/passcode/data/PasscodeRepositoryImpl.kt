package kotli.app.feature.passcode.data

import kotli.app.feature.passcode.domain.model.LockState
import kotli.app.feature.passcode.domain.model.Passcode
import kotli.app.feature.passcode.domain.repository.PasscodeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.datetime.Clock
import shared.data.serialization.ByteArrayStrategy
import shared.data.serialization.SerializationStrategy
import shared.data.source.encryption.EncryptionMethod
import shared.data.source.encryption.EncryptionSource
import shared.data.source.keyvalue.KeyValueSource
import kotlin.math.max
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

class PasscodeRepositoryImpl(
    private val persistentKey: String = "passcode_config",
    private val passcodeLength: Int = 4,
    private val unlockAttemptsCount: Int = 5,
    private val resumeTimeout: Long = 10.seconds.inWholeMilliseconds,
    private val encryptionMethod: (code: String) -> EncryptionMethod = EncryptionMethod::PBKDF2,
    private val encryptionSource: EncryptionSource,
    private val keyValueSource: KeyValueSource,
) : PasscodeRepository {

    private val passcodeStrategy = SerializationStrategy.json(Passcode.serializer())
    private val lockStateFlow = MutableStateFlow(LockState.UNDEFINED)

    override fun getPasscodeLength(): Int {
        return passcodeLength
    }

    override suspend fun getRemainingUnlockAttempts(): Int {
        val passcode = getPasscode() ?: return 0
        return max(0, unlockAttemptsCount - passcode.unlockAttempts)
    }

    override suspend fun setPasscode(passcode: Passcode) {
        keyValueSource.save(persistentKey, passcode, passcodeStrategy)
    }

    override suspend fun getPasscode(): Passcode? {
        return keyValueSource.read(persistentKey, passcodeStrategy)
    }

    override suspend fun reset() {
        keyValueSource.remove(persistentKey, passcodeStrategy)
        lockStateFlow.value = LockState.UNLOCKED
    }

    override suspend fun getLockState(): Flow<LockState> {
        val currentTime = Clock.System.now().toEpochMilliseconds()
        val currentLock = lockStateFlow.value
        val passcode = getPasscode()

        val lock = when {
            passcode == null -> LockState.UNLOCKED
            currentLock == LockState.UNDEFINED -> LockState.LOCKED
            currentTime - passcode.unlockTime > resumeTimeout -> LockState.LOCKED
            else -> LockState.UNLOCKED
        }

        lockStateFlow.value = lock

        return lockStateFlow
    }

    override suspend fun lock(code: String) {
        val salt = ByteArrayStrategy.toString(Random.nextBytes(16))
        val encodedCode = encryptionSource.encrypt(code, encryptionMethod(salt))

        val passcode = Passcode(
            unlockTime = Clock.System.now().toEpochMilliseconds(),
            encodedCode = encodedCode,
            unlockAttempts = 0,
            salt = salt
        )

        setPasscode(passcode)
        lockStateFlow.value = LockState.UNLOCKED
    }

    override suspend fun check(code: String): LockState {
        val passcode = getPasscode() ?: return LockState.UNLOCKED

        return runCatching {
            check(getRemainingUnlockAttempts() > 0) { unknownError() }

            val salt = passcode.salt
            val expectedCode = passcode.encodedCode
            val actualCode = encryptionSource.encrypt(code, encryptionMethod(salt))
            check(actualCode == expectedCode) { unknownError() }

            setPasscode(
                passcode.copy(
                    unlockAttempts = 0,
                    unlockTime = Clock.System.now().toEpochMilliseconds()
                )
            )

            LockState.UNLOCKED
        }.getOrElse {
            setPasscode(
                passcode.copy(
                    unlockAttempts = passcode.unlockAttempts + 1
                )
            )

            LockState.LOCKED
        }
    }

    override suspend fun unlock(code: String): LockState {
        lockStateFlow.value = check(code)

        return lockStateFlow.value
    }

    private fun unknownError(): Nothing = error("unknown error")
}