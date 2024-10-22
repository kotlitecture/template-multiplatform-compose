package kotli.app.feature.home

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.lifecycle.viewmodel.initializer
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotli.app.feature.home.presentation.HomeRoute
import kotli.app.feature.home.presentation.HomeScreen
import kotli.app.feature.home.presentation.HomeViewModel

fun NavGraphBuilder.home(navController: NavHostController) {
    composable<HomeRoute> { HomeScreen() }
}

fun InitializerViewModelFactoryBuilder.home() {
    initializer { HomeViewModel() }
}