package shared.data.source.http

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.plugins.BrowserUserAgent
import io.ktor.client.plugins.HttpRedirect
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import shared.data.source.DataSource

/**
 * A data source implementation that utilizes OkHttp as the underlying HTTP client.
 *
 * @param retries The number of retries to attempt in case of network errors.
 * @param timeout The timeout value for network operations, in milliseconds.
 * @param retryInterval The interval between retry attempts, in milliseconds.
 */
class HttpSource(
    private val retries: Int = 3,
    private val timeout: Long = 30_000L,
    private val retryInterval: Long = 3_000L,
    private val config: HttpClientConfig<*>.() -> Unit = {}
) : DataSource {

    /** https://ktor.io/docs/client-create-multiplatform-application.html */
    val client by lazy {
        HttpClient {
            config(this)
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        useAlternativeNames = false
                    }
                )
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.HEADERS
            }
            install(WebSockets)
            install(HttpRedirect)
            install(HttpTimeout) {
                requestTimeoutMillis = timeout
                connectTimeoutMillis = timeout
                socketTimeoutMillis = timeout
            }
            if (retries > 0) {
                install(HttpRequestRetry) {
                    retryOnServerErrors(retries)
                    retryOnException(retries, true)
                }
            }
            BrowserUserAgent()
            defaultRequest {
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
        }
    }

}

fun Throwable.isHttpTimeoutException(): Boolean {
    val exception = this
    return exception is HttpRequestTimeoutException ||
            exception is ConnectTimeoutException ||
            exception is SocketTimeoutException
}