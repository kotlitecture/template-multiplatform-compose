package kotli.app.di.common

import org.koin.dsl.module
import shared.data.source.http.HttpSource

val httpSourceModule = module {
    single {
        HttpSource(
            timeout = 30_000,
            retries = 3
        )
    }
}