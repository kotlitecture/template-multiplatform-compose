package app.di.viewmodel

import app.AppNavigationRouter
import app.AppViewModel
import app.showcases.ShowcasesViewModel
import app.showcases.datasource.http.basic.BasicHttpViewModel
import app.showcases.datasource.paging.basic.BasicPagingViewModel
import app.ui.navigation.NavigationBarViewModel
import app.ui.screen.template.TemplateViewModel
import app.ui.screen.template_no_args.TemplateNoArgsViewModel
import app.ui.theme.AppThemePersistenceViewModel
import app.ui.theme.AppThemeViewModel
import app.userflow.navigation.a.NavigationAViewModel
import app.userflow.navigation.b.NavigationBViewModel
import app.userflow.navigation.c.NavigationCViewModel
import app.userflow.theme.change.ChangeThemeViewModel
import app.userflow.theme.toggle.ToggleThemeViewModel
import org.koin.dsl.module

val ProvidesViewModels = module {
    // app
    factory { AppThemeViewModel(get()) }
    factory { AppThemePersistenceViewModel(get(), get()) }
    factory { AppViewModel(get(), get()) }
    factory { AppNavigationRouter() }
    // ui
    factory { TemplateNoArgsViewModel(get()) }
    factory { TemplateViewModel(get()) }
    factory { NavigationBarViewModel(get(), get()) }
    // userflow
    factory { ChangeThemeViewModel(get(), get()) }
    factory { ToggleThemeViewModel(get()) }
    factory { NavigationAViewModel() }
    factory { NavigationBViewModel() }
    factory { NavigationCViewModel() }
    // showcases
    factory { ShowcasesViewModel(get()) }
    factory { BasicPagingViewModel(get(), get()) }
    factory { BasicHttpViewModel(get(), get()) }
}