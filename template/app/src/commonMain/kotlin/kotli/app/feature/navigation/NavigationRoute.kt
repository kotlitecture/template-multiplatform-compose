package kotli.app.feature.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotli.app.feature.navigation.a.presentation.ARoute
import kotli.app.feature.navigation.a.presentation.AScreen
import kotli.app.feature.navigation.b.presentation.BRoute
import kotli.app.feature.navigation.b.presentation.BScreen
import kotli.app.feature.navigation.c.presentation.CRoute
import kotli.app.feature.navigation.c.presentation.CScreen

fun NavGraphBuilder.navigation(navController: NavHostController) {
    composable<ARoute> { AScreen() }
    composable<BRoute> { BScreen() }
    composable<CRoute> { CScreen() }
}