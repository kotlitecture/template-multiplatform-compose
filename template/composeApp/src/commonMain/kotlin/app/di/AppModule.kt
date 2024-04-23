package app.di

import app.AppViewModel
import app.ui.theme.AppThemeViewModel
import org.koin.dsl.module

val AppModule = module {
    factory { AppThemeViewModel(get()) }
    factory { AppViewModel(get()) }
}