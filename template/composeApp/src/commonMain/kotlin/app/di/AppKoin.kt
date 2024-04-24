package app.di

import app.di.datasource.ProvidesKeyValueSource
import app.di.state.ProvidesNavigationState
import app.di.state.ProvidesThemeState
import org.koin.core.context.startKoin

val AppKoin = startKoin {
    printLogger()
    modules(
        ProvidesKeyValueSource,
        ProvidesNavigationState,
        ProvidesThemeState,
        ProvidesViewModels,
    )
}

inline fun <reified T : Any> koinGet(): T = AppKoin.koin.get<T>()
inline fun <reified T : Any> koinInject(): Lazy<T> = AppKoin.koin.inject<T>()