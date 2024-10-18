package kotli.app.feature.passcode.common.domain

class UnlockPasscodeUseCase(
    private val repository: PasscodeRepository
) {

    suspend fun invoke(code: String): LockState {
        return repository.unlock(code)
    }

}