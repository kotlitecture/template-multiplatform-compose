package kotli.app

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotli.app.feature.a.presentation.ARoute
import kotli.app.feature.a.presentation.AScreen
import kotli.app.feature.b.presentation.BRoute
import kotli.app.feature.b.presentation.BScreen
import kotli.app.feature.c.presentation.CRoute
import kotli.app.feature.c.presentation.CScreen
import kotli.app.feature.passcode.reset.presentation.ResetPasscodeRoute
import kotli.app.feature.passcode.reset.presentation.ResetPasscodeScreen
import kotli.app.feature.passcode.set.presentation.SetPasscodeRoute
import kotli.app.feature.passcode.set.presentation.SetPasscodeScreen
import kotli.app.feature.showcases.ShowcasesRoute
import kotli.app.feature.showcases.ShowcasesScreen
import shared.presentation.misc.back

interface AppRoute

fun NavGraphBuilder.appRoute(navController: NavHostController) {
    composable<ShowcasesRoute> { entry -> ShowcasesScreen(entry.toRoute()) }
    composable<ARoute> { AScreen() }
    composable<BRoute> { BScreen() }
    composable<CRoute> { CScreen() }
    composable<SetPasscodeRoute> { SetPasscodeScreen(navController::back) }
    composable<ResetPasscodeRoute> { ResetPasscodeScreen(navController::back) }
}