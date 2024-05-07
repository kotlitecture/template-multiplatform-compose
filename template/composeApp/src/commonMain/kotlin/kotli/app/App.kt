package kotli.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotli.app.di.instance
import kotli.app.showcases.ShowcasesViewModel
import kotli.app.showcases.datasource.http.basic.BasicHttpViewModel
import kotli.app.showcases.datasource.keyvalue.`object`.ObjectKeyValueViewModel
import kotli.app.showcases.datasource.keyvalue.primitive.PrimitiveKeyValueViewModel
import kotli.app.showcases.datasource.paging.basic.BasicPagingViewModel
import kotli.app.showcases.navigation.args.from.ArgsNavigationFromViewModel
import kotli.app.showcases.navigation.args.to.ArgsNavigationToViewModel
import kotli.app.showcases.navigation.no_args.from.NoArgsNavigationFromViewModel
import kotli.app.showcases.navigation.no_args.to.NoArgsNavigationToViewModel
import kotli.app.showcases.feature.loader.data.DataLoaderShowcaseViewModel
import kotli.app.ui.screen.template.TemplateViewModel
import kotli.app.ui.screen.template_no_args.TemplateNoArgsViewModel
import kotli.app.ui.theme.AppThemePersistenceViewModel
import kotli.app.ui.theme.AppThemeProvider
import kotli.app.ui.theme.AppThemeViewModel
import kotli.app.feature.loader.data.DataLoaderViewModel
import kotli.app.feature.navigation.NavigationBarViewModel
import kotli.app.feature.navigation.samples.a.NavigationAViewModel
import kotli.app.feature.navigation.samples.b.NavigationBViewModel
import kotli.app.feature.navigation.samples.c.NavigationCViewModel
import kotli.app.feature.theme.change.ChangeThemeViewModel
import kotli.app.feature.theme.toggle.ToggleThemeViewModel
import shared.core.ViewModelProvider

/**
 * Root of the application.
 */
@Composable
fun App() = ViewModelProvider(remember { AppViewModelFactory }) {
    AppThemeProvider {
        AppScreen()
    }
}

private val AppViewModelFactory = viewModelFactory {
    initializer { AppViewModel(instance(), instance(), instance()) }
    initializer { AppThemeViewModel(instance()) }
    initializer { AppThemePersistenceViewModel(instance(), instance()) }
    initializer { TemplateNoArgsViewModel(instance()) }
    initializer { TemplateViewModel(instance()) }
    initializer { ShowcasesViewModel(instance()) }
    initializer { ChangeThemeViewModel(instance(), instance()) }
    initializer { ToggleThemeViewModel(instance()) }
    initializer { BasicPagingViewModel(instance(), instance()) }
    initializer { BasicHttpViewModel(instance(), instance()) }
    initializer { NavigationAViewModel() }
    initializer { NavigationBViewModel() }
    initializer { NavigationCViewModel() }
    initializer { NavigationBarViewModel(instance(), instance()) }
    initializer { NoArgsNavigationFromViewModel(instance()) }
    initializer { NoArgsNavigationToViewModel(instance()) }
    initializer { ArgsNavigationFromViewModel(instance()) }
    initializer { ArgsNavigationToViewModel(instance()) }
    initializer { DataLoaderViewModel(instance()) }
    initializer { DataLoaderShowcaseViewModel(instance(), instance()) }
    initializer { PrimitiveKeyValueViewModel(instance(), instance()) }
    initializer { ObjectKeyValueViewModel(instance(), instance()) }
}
