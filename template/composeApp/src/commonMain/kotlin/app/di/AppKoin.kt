package app.di

import app.di.state.ThemeStateModule
import org.koin.core.context.startKoin

val AppKoin = startKoin {
    printLogger()
    modules(
        ThemeStateModule,
        AppModule
    )
}

inline fun <reified T : Any> koinGet(): T = AppKoin.koin.get<T>()

inline fun <reified T : Any> koinInject(): Lazy<T> = AppKoin.koin.inject<T>()