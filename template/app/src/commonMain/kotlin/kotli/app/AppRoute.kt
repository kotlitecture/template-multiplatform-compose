package kotli.app

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotli.app.feature.a.presentation.ARoute
import kotli.app.feature.a.presentation.AScreen
import kotli.app.feature.b.presentation.BRoute
import kotli.app.feature.b.presentation.BScreen
import kotli.app.feature.c.presentation.CRoute
import kotli.app.feature.c.presentation.CScreen
import kotli.app.feature.passcode.passcode
import kotli.app.feature.showcases.showcases
import kotli.app.feature.theme.theme

interface AppRoute

fun NavGraphBuilder.app(navController: NavHostController) {
    composable<ARoute> { AScreen() }
    composable<BRoute> { BScreen() }
    composable<CRoute> { CScreen() }
    theme(navController)
    passcode(navController)
    showcases(navController)
}