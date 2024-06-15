package kotli.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotli.app.di.get
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
import kotli.app.ui.loader.LoaderViewModel
import kotli.app.feature.navigation.NavigationBarViewModel
import kotli.app.feature.navigation.samples.a.NavigationAViewModel
import kotli.app.feature.navigation.samples.b.NavigationBViewModel
import kotli.app.feature.navigation.samples.c.NavigationCViewModel
import kotli.app.feature.theme.change.ChangeThemeViewModel
import kotli.app.feature.theme.toggle.ToggleThemeViewModel
import shared.presentation.ViewModelProvider

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
    initializer { AppViewModel(get(), get(), get()) }
    initializer { AppThemeViewModel(get()) }
    initializer { AppThemePersistenceViewModel(get(), get()) }
    initializer { TemplateNoArgsViewModel(get()) }
    initializer { TemplateViewModel(get()) }
    initializer { ShowcasesViewModel(get()) }
    initializer { ChangeThemeViewModel(get(), get()) }
    initializer { ToggleThemeViewModel(get()) }
    initializer { BasicPagingViewModel(get(), get()) }
    initializer { BasicHttpViewModel(get(), get()) }
    initializer { NavigationAViewModel() }
    initializer { NavigationBViewModel() }
    initializer { NavigationCViewModel() }
    initializer { NavigationBarViewModel(get(), get()) }
    initializer { NoArgsNavigationFromViewModel(get()) }
    initializer { NoArgsNavigationToViewModel(get()) }
    initializer { ArgsNavigationFromViewModel(get()) }
    initializer { ArgsNavigationToViewModel(get()) }
    initializer { LoaderViewModel(get()) }
    initializer { DataLoaderShowcaseViewModel(get(), get()) }
    initializer { PrimitiveKeyValueViewModel(get(), get()) }
    initializer { ObjectKeyValueViewModel(get(), get()) }
}
