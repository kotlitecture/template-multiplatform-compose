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
import app.ui.theme.AppThemeViewModel
import app.userflow.navigation.NavigationBarViewModel
import app.userflow.navigation.samples.a.NavigationAViewModel
import app.userflow.navigation.samples.b.NavigationBViewModel
import app.userflow.navigation.samples.c.NavigationCViewModel
import app.userflow.theme.change.ChangeThemeViewModel
import app.userflow.theme.toggle.ToggleThemeViewModel
import shared.core.BaseViewModel
import shared.core.provideViewModel

val AppViewModelFactory = viewModelFactory {
    initializer { instance<AppViewModel>() }
    initializer { instance<AppThemeViewModel>() }
    initializer { instance<AppThemePersistenceViewModel>() }
    initializer { instance<TemplateNoArgsViewModel>() }
    initializer { instance<TemplateViewModel>() }
    initializer { instance<ShowcasesViewModel>() }
    initializer { instance<ChangeThemeViewModel>() }
    initializer { instance<ToggleThemeViewModel>() }
    initializer { instance<BasicPagingViewModel>() }
    initializer { instance<BasicHttpViewModel>() }
    initializer { instance<NavigationAViewModel>() }
    initializer { instance<NavigationBViewModel>() }
    initializer { instance<NavigationCViewModel>() }
    initializer { instance<NavigationBarViewModel>() }
    initializer { instance<NoArgsNavigationFromViewModel>() }
    initializer { instance<NoArgsNavigationToViewModel>() }
    initializer { instance<ArgsNavigationFromViewModel>() }
    initializer { instance<ArgsNavigationToViewModel>() }
}

@Composable
inline fun <reified VM : BaseViewModel> appViewModel(key: String? = null): VM =
    provideViewModel(
        key = key,
        factory = AppViewModelFactory
    )