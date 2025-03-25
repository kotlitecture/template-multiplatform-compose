package kotli.app.navigation.provide.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import kotli.app.common.presentation.navigation.BottomProvider
import shared.presentation.viewmodel.provideViewModel

@Composable
fun BottomNavigationProvider(
    navController: NavHostController
) {
    val viewModel: NavigationViewModel = provideViewModel()
    LaunchedEffect(navController) { viewModel.onBind(navController) }

    BottomProvider(viewModel.state)
}