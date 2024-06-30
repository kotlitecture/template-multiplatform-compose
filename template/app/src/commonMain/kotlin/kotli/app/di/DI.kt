package kotli.app.di

import kotli.app.di.data.analyticsSourceModule
import kotli.app.di.data.cacheSourceModule
import kotli.app.di.data.configSourceModule
import kotli.app.di.data.httpSourceModule
import kotli.app.di.data.keyValueSourceModule
import kotli.app.di.data.pagingSourceModule
import kotli.app.di.data.sqlDelightSourceModule
import kotli.app.di.state.ProvidesAppState
import kotli.app.di.state.ProvidesNavigationBarState
import kotli.app.di.state.ProvidesNavigationState
import kotli.app.di.state.ProvidesThemeStore
import org.koin.core.context.startKoin

val koinDI = startKoin {
    printLogger()
    modules(
        analyticsSourceModule,
        configSourceModule,
        cacheSourceModule,
        httpSourceModule,
        keyValueSourceModule,
        pagingSourceModule,
        sqlDelightSourceModule,
        ProvidesNavigationBarState,
        ProvidesNavigationState,
        ProvidesThemeStore,
        ProvidesAppState
    )
}

inline fun <reified T : Any> get(): T = koinDI.koin.get<T>()