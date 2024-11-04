package kotli.app.common

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.lifecycle.viewmodel.initializer
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import kotli.app.common.presentation.loader.LoaderViewModel

fun NavGraphBuilder.common(navController: NavHostController) {
}

fun InitializerViewModelFactoryBuilder.common() {
    initializer { LoaderViewModel() }
}