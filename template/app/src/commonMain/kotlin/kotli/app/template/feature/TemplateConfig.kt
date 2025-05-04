package kotli.app.template.feature

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.lifecycle.viewmodel.initializer
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotli.app.template.feature.presentation.TemplateRoute
import kotli.app.template.feature.presentation.TemplateScreen
import kotli.app.template.feature.presentation.TemplateViewModel
import org.koin.dsl.module
import shared.presentation.navigation.back

fun NavGraphBuilder.template(navController: NavHostController) {
    composable<TemplateRoute> {
        val route = it.toRoute<TemplateRoute>()
        TemplateScreen(
            title = route.title,
            onBack = navController::back
        )
    }
}

fun InitializerViewModelFactoryBuilder.template() {
    initializer { TemplateViewModel() }
}

val template = module {}