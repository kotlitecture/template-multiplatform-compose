package app.di

import app.di.datasource.ProvidesAnalyticsSource
import app.di.datasource.ProvidesConfigSource
import app.di.datasource.ProvidesHttpSource
import app.di.datasource.ProvidesKeyValueSource
import app.di.datasource.ProvidesPagingSource
import app.di.state.ProvidesNavigationBarState
import app.di.state.ProvidesNavigationState
import app.di.state.ProvidesThemeState
import app.di.viewmodel.ProvidesViewModels
import org.koin.core.context.startKoin

val koinDI = startKoin {
    printLogger()
    modules(
        ProvidesAnalyticsSource,
        ProvidesConfigSource,
        ProvidesHttpSource,
        ProvidesKeyValueSource,
        ProvidesPagingSource,
        ProvidesNavigationBarState,
        ProvidesNavigationState,
        ProvidesThemeState,
        ProvidesViewModels,
    )
}

inline fun <reified T : Any> instance(): T = koinDI.koin.get<T>()