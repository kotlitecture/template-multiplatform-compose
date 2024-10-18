package kotli.app.koin.feature

import kotli.app.feature.passcode.model.PasscodeStore
import kotli.app.feature.passcode.usecase.ForgotPasscode
import kotli.app.feature.passcode.usecase.InitPasscode
import kotli.app.feature.passcode.usecase.IsPasscodeSet
import kotli.app.feature.passcode.usecase.PausePasscode
import kotli.app.feature.passcode.usecase.ResetPasscode
import kotli.app.feature.passcode.usecase.SetPasscode
import kotli.app.feature.passcode.usecase.UnlockPasscode
import org.koin.dsl.module

val passcodeModule = module {
    single { PasscodeStore() }

    factory { InitPasscode(get(), get()) }
    factory { ResetPasscode(get(), get()) }
    factory { IsPasscodeSet(get(), get()) }
    factory { PausePasscode(get(), get()) }
    factory { ForgotPasscode(get(), get()) }
    factory { SetPasscode(get(), get(), get()) }
    factory { UnlockPasscode(get(), get(), get()) }
}