package kotli.app.koin.feature

import kotli.app.feature.passcode.common.data.PasscodeRepositoryImpl
import kotli.app.feature.passcode.common.domain.PasscodeRepository
import kotli.app.feature.passcode.forgot.domain.ForgotPasscodeUseCase
import kotli.app.feature.passcode.provider.domain.GetPasscodeUseCase
import kotli.app.feature.passcode.provider.domain.UpdatePasscodeUseCase
import kotli.app.feature.passcode.unlock.domain.GetPasscodeLengthUseCase
import kotli.app.feature.passcode.unlock.domain.GetRemainingAttemptsUseCase
import kotli.app.feature.passcode.usecase.IsPasscodeSet
import kotli.app.feature.passcode.usecase.ResetPasscode
import kotli.app.feature.passcode.usecase.SetPasscode
import kotli.app.feature.passcode.common.domain.UnlockPasscodeUseCase
import org.koin.dsl.module

val passcodeModule = module {
    single<PasscodeRepository> {
        PasscodeRepositoryImpl(
            keyValueSource = get(),
            encryptionSource = get()
        )
    }

    factory { SetPasscode(get()) }
    factory { ResetPasscode(get()) }
    factory { IsPasscodeSet(get()) }
    factory { UnlockPasscodeUseCase(get()) }
    factory { GetPasscodeUseCase(get()) }
    factory { UpdatePasscodeUseCase(get()) }
    factory { ForgotPasscodeUseCase(get(), get()) }
    factory { GetPasscodeLengthUseCase(get()) }
    factory { GetRemainingAttemptsUseCase(get()) }
}