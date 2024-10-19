package kotli.app.feature.navigation.provide.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun NavigationProvider(
    navController: NavController,
    content: @Composable () -> Unit
) {
    content()
}