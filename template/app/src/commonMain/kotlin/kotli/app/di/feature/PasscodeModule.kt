package kotli.app.di.feature

import kotli.app.feature.passcode.data.PasscodeRepositoryImpl
import kotli.app.feature.passcode.domain.repository.PasscodeRepository
import kotli.app.feature.passcode.domain.usecase.CheckPasscodeUseCase
import kotli.app.feature.passcode.domain.usecase.ForgotPasscodeUseCase
import kotli.app.feature.passcode.domain.usecase.GetLockStateUseCase
import kotli.app.feature.passcode.domain.usecase.GetPasscodeLengthUseCase
import kotli.app.feature.passcode.domain.usecase.GetRemainingAttemptsUseCase
import kotli.app.feature.passcode.domain.usecase.IsPasscodeSetUseCase
import kotli.app.feature.passcode.domain.usecase.ResetPasscodeUseCase
import kotli.app.feature.passcode.domain.usecase.SetPasscodeUseCase
import kotli.app.feature.passcode.domain.usecase.UnlockPasscodeUseCase
import kotli.app.feature.passcode.domain.usecase.UpdatePasscodeUseCase
import org.koin.dsl.module
import kotlin.time.Duration.Companion.seconds

val passcodeModule = module {
    single<PasscodeRepository> {
        PasscodeRepositoryImpl(
            passcodeLength = 4,
            unlockAttemptsCount = 5,
            persistentKey = "passcode_config",
            resumeTimeout = 10.seconds.inWholeMilliseconds,
            encryptionSource = get(),
            settingsSource = get(),
        )
    }
    factory { ForgotPasscodeUseCase(get(), get()) }
    factory { GetPasscodeLengthUseCase(get()) }
    factory { GetLockStateUseCase(get()) }
    factory { GetRemainingAttemptsUseCase(get()) }
    factory { IsPasscodeSetUseCase(get()) }
    factory { ResetPasscodeUseCase(get()) }
    factory { SetPasscodeUseCase(get()) }
    factory { UnlockPasscodeUseCase(get()) }
    factory { UpdatePasscodeUseCase(get()) }
    factory { CheckPasscodeUseCase(get()) }
}