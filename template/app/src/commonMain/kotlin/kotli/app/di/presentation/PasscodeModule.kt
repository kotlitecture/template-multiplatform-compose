package kotli.app.di.presentation

import kotli.app.presentation.passcode.PasscodeStore
import kotli.app.presentation.passcode.usecase.GetPasscodeState
import kotli.app.presentation.passcode.usecase.IsPasscodeExpired
import kotli.app.presentation.passcode.usecase.SetPasscode
import kotli.app.presentation.passcode.usecase.UnlockPasscode
import kotli.app.presentation.passcode.usecase.UpdatePasscodeState
import org.koin.dsl.module

val passcodeModule = module {
    single { PasscodeStore() }

    factory { GetPasscodeState(get(), get()) }
    factory { IsPasscodeExpired(get()) }
    factory { SetPasscode(get(), get(), get()) }
    factory { UnlockPasscode(get(), get(), get()) }
    factory { UpdatePasscodeState(get(), get()) }
}