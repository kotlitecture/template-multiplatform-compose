package kotli.app.feature.passcode

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotli.app.feature.passcode.presentation.reset.ResetPasscodeRoute
import kotli.app.feature.passcode.presentation.reset.ResetPasscodeScreen
import kotli.app.feature.passcode.presentation.set.SetPasscodeRoute
import kotli.app.feature.passcode.presentation.set.SetPasscodeScreen
import shared.presentation.misc.back

fun NavGraphBuilder.passcode(navController: NavHostController) {
    composable<SetPasscodeRoute> { SetPasscodeScreen(navController::back) }
    composable<ResetPasscodeRoute> { ResetPasscodeScreen(navController::back) }
}