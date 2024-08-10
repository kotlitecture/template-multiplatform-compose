package kotli.app.di.presentation

import kotli.app.presentation.passcode.model.PasscodeStore
import kotli.app.presentation.passcode.usecase.ForgotPasscode
import kotli.app.presentation.passcode.usecase.InitPasscode
import kotli.app.presentation.passcode.usecase.PausePasscode
import kotli.app.presentation.passcode.usecase.ResetPasscode
import kotli.app.presentation.passcode.usecase.SetPasscode
import kotli.app.presentation.passcode.usecase.UnlockPasscode
import org.koin.dsl.module

val passcodeModule = module {
    single { PasscodeStore() }

    factory { InitPasscode(get(), get()) }
    factory { PausePasscode(get(), get()) }
    factory { ResetPasscode(get(), get()) }
    factory { ForgotPasscode(get(), get()) }
    factory { SetPasscode(get(), get(), get()) }
    factory { UnlockPasscode(get(), get(), get()) }
}