package kotli.app

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotli.app.common.presentation.navigation.BottomProvider
import kotli.app.common.presentation.navigation.NavigationProvider
import kotli.app.di.get
import kotli.app.presentation.passcode.PasscodeProvider
import kotli.app.presentation.showcases.Showcases
import kotli.app.presentation.showcases.ShowcasesScreen
import kotli.app.theme.provide.presentation.AppThemeProvider
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
        content = { AppNavHost(startDestination, navController) }
    )
}

@Composable
private fun AppNavHost(startDestination: Any, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = { fadeIn(animationSpec = tween(100)) },
        exitTransition = { fadeOut(animationSpec = tween(100)) },
        builder = {
            composable<Showcases> { ShowcasesScreen() }
        }
    )
}
