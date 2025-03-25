package kotli.app.passcode

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.lifecycle.viewmodel.initializer
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotli.app.get
import kotli.app.passcode.data.PasscodeRepositoryImpl
import kotli.app.passcode.domain.repository.PasscodeRepository
import kotli.app.passcode.domain.usecase.*
import kotli.app.passcode.presentation.forgot.ForgotPasscodeViewModel
import kotli.app.passcode.presentation.provide.PasscodeViewModel
import kotli.app.passcode.presentation.reset.ResetPasscodeRoute
import kotli.app.passcode.presentation.reset.ResetPasscodeScreen
import kotli.app.passcode.presentation.reset.ResetPasscodeViewModel
import kotli.app.passcode.presentation.set.SetPasscodeRoute
import kotli.app.passcode.presentation.set.SetPasscodeScreen
import kotli.app.passcode.presentation.set.SetPasscodeViewModel
import kotli.app.passcode.presentation.unlock.UnlockPasscodeViewModel
import org.koin.dsl.module
import shared.presentation.navigation.back
import kotlin.time.Duration.Companion.seconds

fun NavGraphBuilder.passcode(navController: NavHostController) {
    composable<SetPasscodeRoute> { SetPasscodeScreen(navController::back) }
    composable<ResetPasscodeRoute> { ResetPasscodeScreen(navController::back) }
}

fun InitializerViewModelFactoryBuilder.passcode() {
    initializer { SetPasscodeViewModel(get(), get(), get(), get(), get()) }
    initializer { ResetPasscodeViewModel(get(), get(), get(), get()) }
    initializer { UnlockPasscodeViewModel(get(), get(), get()) }
    initializer { PasscodeViewModel(get(), get()) }
    initializer { ForgotPasscodeViewModel(get()) }
}

val passcode = module {
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