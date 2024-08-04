package kotli.app.di.presentation

import kotli.app.presentation.passcode.PasscodeStore
import org.koin.dsl.module

val passcodeModule = module {
    single { PasscodeStore() }
    factory { PasscodeManager(get()) }
}