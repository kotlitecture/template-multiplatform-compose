package kotli.app.di

import kotli.app.di.data.analyticsSourceModule
import kotli.app.di.data.cacheSourceModule
import kotli.app.di.data.configSourceModule
import kotli.app.di.data.httpSourceModule
import kotli.app.di.data.keyValueSourceModule
import kotli.app.di.data.pagingSourceModule
import kotli.app.di.data.sqlDelightSourceModule
import kotli.app.di.presentation.appModule
import kotli.app.di.presentation.navigationBarModule
import kotli.app.di.presentation.navigationModule
import kotli.app.di.presentation.themeModule
import kotli.app.factory.configureKoin
import org.koin.core.context.startKoin

val koinApp = startKoin {
    printLogger()
    modules(
        analyticsSourceModule,
        configSourceModule,
        cacheSourceModule,
        httpSourceModule,
        keyValueSourceModule,
        pagingSourceModule,
        sqlDelightSourceModule,
        navigationBarModule,
        navigationModule,
        themeModule,
        appModule
    )
    configureKoin(this)
}

inline fun <reified T : Any> get(): T = koinApp.koin.get<T>()