package kotli.app.di.presentation

import kotli.app.presentation.passcode.model.PasscodeStore
import kotli.app.presentation.passcode.usecase.InitPasscode
import kotli.app.presentation.passcode.usecase.SetPasscode
import kotli.app.presentation.passcode.usecase.UnlockPasscode
import kotli.app.presentation.passcode.usecase.PausePasscode
import org.koin.dsl.module

val passcodeModule = module {
    single { PasscodeStore() }

    factory { InitPasscode(get(), get()) }
    factory { SetPasscode(get(), get(), get()) }
    factory { UnlockPasscode(get(), get(), get()) }
    factory { PausePasscode(get(), get()) }
}