package kotli.app.di.data

import kotli.app.common.data.source.config.AppConfigSource
import org.koin.dsl.module
import shared.data.source.http.HttpSource

val httpSourceModule = module {
    single {
        val config: AppConfigSource = get()
        HttpSource(
            timeout = config.getHttpTimeout(),
            retries = config.getHttpRetryCount()
        )
    }
}