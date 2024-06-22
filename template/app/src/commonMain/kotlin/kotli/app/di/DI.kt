package kotli.app.di

import kotli.app.di.datasource.ProvidesAnalyticsSource
import kotli.app.di.datasource.ProvidesConfigSource
import kotli.app.di.datasource.ProvidesHttpSource
import kotli.app.di.datasource.ProvidesKeyValueSource
import kotli.app.di.datasource.ProvidesPagingSource
import kotli.app.di.datasource.ProvidesSqlDelightSource
import kotli.app.di.state.ProvidesAppState
import kotli.app.di.state.ProvidesNavigationBarState
import kotli.app.di.state.ProvidesNavigationState
import kotli.app.di.state.ProvidesThemeState
import org.koin.core.context.startKoin

val koinDI = startKoin {
    printLogger()
    modules(
        ProvidesAnalyticsSource,
        ProvidesConfigSource,
        ProvidesHttpSource,
        ProvidesKeyValueSource,
        ProvidesPagingSource,
        ProvidesSqlDelightSource,
        ProvidesNavigationBarState,
        ProvidesNavigationState,
        ProvidesThemeState,
        ProvidesAppState
    )
}

inline fun <reified T : Any> get(): T = koinDI.koin.get<T>()