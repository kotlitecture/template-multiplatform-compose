package kotli.app.platform

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import org.koin.core.module.Module

expect fun NavGraphBuilder.platform(navController: NavHostController)

expect fun InitializerViewModelFactoryBuilder.platform()

expect val platform: Module