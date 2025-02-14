package kotli.app.di

import kotli.app.di.common.aiSourceModule
import kotli.app.di.common.analyticsSourceModule
import kotli.app.di.common.cacheSourceModule
import kotli.app.di.common.configSourceModule
import kotli.app.di.common.encryptionSourceModule
import kotli.app.di.common.httpSourceModule
import kotli.app.di.common.settingsSourceModule
import kotli.app.di.common.pagingSourceModule
import kotli.app.di.common.sqlDelightSourceModule
import kotli.app.di.feature.themeModule
import kotli.app.di.feature.appModule
import kotli.app.di.feature.passcodeModule
import kotli.app.di.platform.configureKoin
import org.koin.core.context.startKoin

val koinApp = startKoin {
    printLogger()
    modules(
        aiSourceModule,
        analyticsSourceModule,
        cacheSourceModule,
        configSourceModule,
        encryptionSourceModule,
        httpSourceModule,
        settingsSourceModule,
        pagingSourceModule,
        sqlDelightSourceModule,
        passcodeModule,
        themeModule,
        appModule,
    )
    configureKoin(this)
}

inline fun <reified T : Any> inject(): T = koinApp.koin.get<T>()