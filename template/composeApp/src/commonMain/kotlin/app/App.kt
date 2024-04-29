package app

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import app.di.instance
import app.showcases.ShowcasesViewModel
import app.showcases.datasource.http.basic.BasicHttpViewModel
import app.showcases.datasource.paging.basic.BasicPagingViewModel
import app.showcases.navigation.args.from.ArgsNavigationFromViewModel
import app.showcases.navigation.args.to.ArgsNavigationToViewModel
import app.showcases.navigation.no_args.from.NoArgsNavigationFromViewModel
import app.showcases.navigation.no_args.to.NoArgsNavigationToViewModel
import app.ui.screen.template.TemplateViewModel
import app.ui.screen.template_no_args.TemplateNoArgsViewModel
import app.ui.theme.AppThemePersistenceViewModel
import app.ui.theme.AppThemeProvider
import app.ui.theme.AppThemeViewModel
import app.userflow.navigation.NavigationBarViewModel
import app.userflow.navigation.samples.a.NavigationAViewModel
import app.userflow.navigation.samples.b.NavigationBViewModel
import app.userflow.navigation.samples.c.NavigationCViewModel
import app.userflow.theme.change.ChangeThemeViewModel
import app.userflow.theme.toggle.ToggleThemeViewModel
import shared.core.BaseViewModel
import shared.core.ViewModelProvider
import shared.core.provideViewModel

@Composable
fun App() = ViewModelProvider(AppViewModelFactory) {
    AppThemeProvider {
        AppScreen()
    }
}

private val AppViewModelFactory = viewModelFactory {
    initializer { AppViewModel(instance(), instance()) }
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
}
