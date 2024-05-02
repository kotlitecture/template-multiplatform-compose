package kotli.app.di.datasource

import kotli.app.datasource.config.AppConfigSource
import org.koin.dsl.module
import shared.data.datasource.http.HttpSource

val ProvidesHttpSource = module {
    single {
        val config: AppConfigSource = get()
        HttpSource(
            timeout = config.getHttpTimeout(),
            retries = config.getHttpRetryCount()
        )
    }
}