package kotli.app.profile

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.lifecycle.viewmodel.initializer
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotli.app.home.presentation.HomeRoute
import kotli.app.home.presentation.HomeScreen
import kotli.app.home.presentation.HomeViewModel
import org.koin.dsl.module

fun NavGraphBuilder.profile(navController: NavHostController) {}

fun InitializerViewModelFactoryBuilder.profile() {}

val profile = module {}