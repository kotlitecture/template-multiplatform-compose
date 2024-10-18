package kotli.app.koin

import kotli.app.koin.common.aiSourceModule
import kotli.app.koin.common.analyticsSourceModule
import kotli.app.koin.common.cacheSourceModule
import kotli.app.koin.common.configSourceModule
import kotli.app.koin.common.encryptionSourceModule
import kotli.app.koin.common.httpSourceModule
import kotli.app.koin.common.keyValueSourceModule
import kotli.app.koin.common.pagingSourceModule
import kotli.app.koin.common.sqlDelightSourceModule
import kotli.app.koin.feature.themeModule
import kotli.app.koin.feature.appModule
import kotli.app.koin.feature.passcodeModule
import kotli.app.koin.platform.configureKoin
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
        keyValueSourceModule,
        pagingSourceModule,
        sqlDelightSourceModule,
        appModule,
        passcodeModule,
        themeModule,
    )
    configureKoin(this)
}

inline fun <reified T : Any> get(): T = koinApp.koin.get<T>()