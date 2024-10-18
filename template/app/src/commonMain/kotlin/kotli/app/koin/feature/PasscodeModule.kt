package kotli.app.koin.feature

import kotli.app.feature.passcode.common.data.PasscodeRepositoryImpl
import kotli.app.feature.passcode.common.domain.repository.PasscodeRepository
import kotli.app.feature.passcode.common.domain.usecase.CheckPasscodeUseCase
import kotli.app.feature.passcode.common.domain.usecase.ForgotPasscodeUseCase
import kotli.app.feature.passcode.common.domain.usecase.GetLockStateUseCase
import kotli.app.feature.passcode.common.domain.usecase.GetPasscodeLengthUseCase
import kotli.app.feature.passcode.common.domain.usecase.GetRemainingAttemptsUseCase
import kotli.app.feature.passcode.common.domain.usecase.IsPasscodeSetUseCase
import kotli.app.feature.passcode.common.domain.usecase.ResetPasscodeUseCase
import kotli.app.feature.passcode.common.domain.usecase.SetPasscodeUseCase
import kotli.app.feature.passcode.common.domain.usecase.UnlockPasscodeUseCase
import kotli.app.feature.passcode.common.domain.usecase.UpdatePasscodeUseCase
import org.koin.dsl.module

val passcodeModule = module {
    single<PasscodeRepository> {
        PasscodeRepositoryImpl(
            keyValueSource = get(),
            encryptionSource = get()
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