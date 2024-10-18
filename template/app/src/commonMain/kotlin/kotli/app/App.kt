package kotli.app

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotli.app.common.presentation.navigation.BottomProvider
import kotli.app.common.presentation.navigation.NavigationProvider
import kotli.app.di.get
import kotli.app.feature.a.domain.ARoute
import kotli.app.feature.a.presentation.AScreen
import kotli.app.feature.b.domain.BRoute
import kotli.app.feature.b.presentation.BScreen
import kotli.app.feature.c.domain.CRoute
import kotli.app.feature.c.presentation.CScreen
import kotli.app.feature.passcode.PasscodeProvider
import kotli.app.feature.showcases.ShowcasesRoute
import kotli.app.feature.showcases.ShowcasesScreen
import kotli.app.feature.theme.provide.presentation.AppThemeProvider
import shared.design.container.AppScaffold
import shared.presentation.viewmodel.ViewModelProvider
import shared.presentation.viewmodel.provideViewModel

@Composable
fun App() = ViewModelProvider(get()) {
    val viewModel: AppViewModel = provideViewModel()
    val navController = rememberNavController()
    val state = viewModel.state

    LaunchedEffect(navController) { viewModel.onBind(navController) }

    AppThemeProvider {
        PasscodeProvider { // {userflow.passcode.local}
            NavigationProvider(state.navigationState) { // {userflow.navigation}
                AppContent(state, navController)
            } // {userflow.navigation}
        } // {userflow.passcode.local}
    }
}

@Composable
private fun AppContent(state: AppState, navController: NavHostController) {
    val startDestination = state.startDestination ?: return
    AppScaffold(
        snackbarState = state.snackbarState,
        bottomBar = { BottomProvider(state.navigationState) },
        content = {
            NavHost(
                navController = navController,
                startDestination = startDestination,
                enterTransition = { fadeIn(animationSpec = tween(state.transitionDuration)) },
                exitTransition = { fadeOut(animationSpec = tween(state.transitionDuration)) },
                builder = { graph(navController) }
            )
        }
    )
}

private fun NavGraphBuilder.graph(navController: NavHostController) {
    composable<ShowcasesRoute> { entry -> ShowcasesScreen(entry.toRoute()) }
    composable<ARoute> { entry -> AScreen(entry.toRoute()) }
    composable<BRoute> { entry -> BScreen(entry.toRoute()) }
    composable<CRoute> { entry -> CScreen(entry.toRoute()) }
}
