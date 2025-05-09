package kotli.app.app.presentation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import kotli.app.app.app
import kotli.app.navigation.provide.presentation.BottomNavigationProvider
import kotli.app.navigation.provide.presentation.NavigationProvider
import kotli.app.passcode.presentation.provide.PasscodeProvider
import kotli.app.theme.provide.presentation.ThemeProvider
import shared.presentation.ui.container.DsScaffold
import shared.presentation.viewmodel.ViewModelProvider
import shared.presentation.viewmodel.provideViewModel

@Composable
fun App() = ViewModelProvider({ app() }) {
    val viewModel: AppViewModel = provideViewModel()
    val navController = rememberNavController()
    val state = viewModel.state
    ThemeProvider {
        PasscodeProvider { // {userflow.passcode.basic}
            NavigationProvider(navController) { // {userflow.navigation}
                AppScaffold(state, navController)
            } // {userflow.navigation}
        } // {userflow.passcode.basic}
    }
}

@Composable
private fun AppScaffold(state: AppState, navController: NavHostController) {
    val startDestination = state.startDestination ?: return
    DsScaffold(
        snackbarState = state.snackbarState,
        bottomBar = { BottomNavigationProvider(navController) }
    ) { paddings ->
        val modifier = Modifier.fillMaxSize().padding(paddings)
        AppContent(modifier, state, startDestination, navController)
    }
}

@Composable
private fun AppContent(
    modifier: Modifier,
    state: AppState,
    startDestination: Any,
    navController: NavHostController,
) {
    val transition = tween<Float>(state.transitionDuration)
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
        contentAlignment = Alignment.Center,
        enterTransition = { fadeIn(animationSpec = transition) },
        exitTransition = { fadeOut(animationSpec = transition) },
        builder = { app(navController) }
    )
}
