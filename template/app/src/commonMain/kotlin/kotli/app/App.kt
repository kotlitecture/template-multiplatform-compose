package kotli.app

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import kotli.app.common.presentation.navigation.BottomProvider
import kotli.app.common.presentation.navigation.NavigationProvider
import kotli.app.feature.passcode.presentation.provide.PasscodeProvider
import kotli.app.feature.theme.provide.presentation.ThemeProvider
import kotli.app.koin.get
import shared.design.container.AppScaffold
import shared.presentation.viewmodel.ViewModelProvider
import shared.presentation.viewmodel.provideViewModel

@Composable
fun App() = ViewModelProvider(get()) {
    val viewModel: AppViewModel = provideViewModel()
    val navController = rememberNavController()
    val state = viewModel.state

    LaunchedEffect(navController) { viewModel.onBind(navController) }

    ThemeProvider {
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
                builder = { app(navController) }
            )
        }
    )
}
