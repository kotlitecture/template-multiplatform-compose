package kotli.app.feature.navigation.provide.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import shared.presentation.viewmodel.provideViewModel

@Composable
fun NavigationProvider(
    navController: NavHostController,
    content: @Composable () -> Unit
) {
    val viewModel: NavigationViewModel = provideViewModel()
    LaunchedEffect(navController) { viewModel.onBind(navController) }

    content()
}