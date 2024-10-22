package kotli.app.feature.passcode

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.lifecycle.viewmodel.initializer
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotli.app.feature.passcode.presentation.forgot.ForgotPasscodeViewModel
import kotli.app.feature.passcode.presentation.provide.PasscodeViewModel
import kotli.app.feature.passcode.presentation.reset.ResetPasscodeRoute
import kotli.app.feature.passcode.presentation.reset.ResetPasscodeScreen
import kotli.app.feature.passcode.presentation.reset.ResetPasscodeViewModel
import kotli.app.feature.passcode.presentation.set.SetPasscodeRoute
import kotli.app.feature.passcode.presentation.set.SetPasscodeScreen
import kotli.app.feature.passcode.presentation.set.SetPasscodeViewModel
import kotli.app.feature.passcode.presentation.unlock.UnlockPasscodeViewModel
import kotli.app.di.inject
import shared.presentation.misc.back

fun NavGraphBuilder.passcode(navController: NavHostController) {
    composable<SetPasscodeRoute> { SetPasscodeScreen(navController::back) }
    composable<ResetPasscodeRoute> { ResetPasscodeScreen(navController::back) }
}

fun InitializerViewModelFactoryBuilder.passcode() {
    initializer { PasscodeViewModel(inject(), inject()) }
    initializer { SetPasscodeViewModel(inject(), inject(), inject(), inject(), inject()) }
    initializer { ResetPasscodeViewModel(inject(), inject(), inject(), inject()) }
    initializer { UnlockPasscodeViewModel(inject(), inject(), inject()) }
    initializer { ForgotPasscodeViewModel(inject()) }
}