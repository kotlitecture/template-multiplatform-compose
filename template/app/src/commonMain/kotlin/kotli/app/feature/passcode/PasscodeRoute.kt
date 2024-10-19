package kotli.app.feature.passcode

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotli.app.feature.passcode.reset.presentation.ResetPasscodeRoute
import kotli.app.feature.passcode.reset.presentation.ResetPasscodeScreen
import kotli.app.feature.passcode.set.presentation.SetPasscodeRoute
import kotli.app.feature.passcode.set.presentation.SetPasscodeScreen
import shared.presentation.misc.back

fun NavGraphBuilder.passcode(navController: NavHostController) {
    composable<SetPasscodeRoute> { SetPasscodeScreen(navController::back) }
    composable<ResetPasscodeRoute> { ResetPasscodeScreen(navController::back) }
}