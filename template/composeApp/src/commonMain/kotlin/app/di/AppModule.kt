package app.di

import app.AppNavigationRouter
import app.AppViewModel
import app.ui.screen.template.TemplateViewModel
import app.ui.screen.template_no_args.TemplateNoArgsViewModel
import app.ui.theme.AppThemeViewModel
import org.koin.dsl.module

val AppModule = module {
    // app
    factory { AppThemeViewModel(get()) }
    factory { AppViewModel(get(), get()) }
    factory { AppNavigationRouter() }

    // ui -> screen
    factory { TemplateNoArgsViewModel(get()) }
    factory { TemplateViewModel(get()) }
}