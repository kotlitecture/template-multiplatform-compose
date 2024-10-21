package kotli.app

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import kotli.app.feature.navigation.provide.presentation.BottomNavigationProvider
import kotli.app.feature.navigation.provide.presentation.NavigationProvider
import kotli.app.feature.passcode.presentation.provide.PasscodeProvider
import kotli.app.feature.theme.provide.presentation.ThemeProvider
import shared.design.container.AppScaffold
import shared.presentation.viewmodel.ViewModelProvider
import shared.presentation.viewmodel.provideViewModel

@Composable
fun App() = ViewModelProvider({ app() }) {
    val viewModel: AppViewModel = provideViewModel()
    val navController = rememberNavController()
    val state = viewModel.state

    ThemeProvider {
        PasscodeProvider { // {userflow.passcode.local}
            NavigationProvider(navController) { // {userflow.navigation}
                state.startDestination?.let { startDestination ->
                    AppScaffold(
                        snackbarState = state.snackbarState,
                        bottomBar = { BottomNavigationProvider(navController) },
                        content = { paddings ->
                            val transition = remember { tween<Float>(state.transitionDuration) }
                            NavHost(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(paddings),
                                navController = navController,
                                startDestination = startDestination,
                                enterTransition = { fadeIn(animationSpec = transition) },
                                exitTransition = { fadeOut(animationSpec = transition) },
                                builder = { app(navController) }
                            )
                        }
                    )
                }
            } // {userflow.navigation}
        } // {userflow.passcode.local}
    }
}
