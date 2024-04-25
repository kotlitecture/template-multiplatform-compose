package core.data.misc.extensions

import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.utils.unwrapCancellationException
import kotlinx.coroutines.CancellationException

fun Throwable.isIgnoredException(): Boolean {
    return isCancellationException() || isTimeoutException()
}

fun Throwable.isCancellationException(): Boolean {
    return unwrapCancellationException() is CancellationException
}

fun Throwable.isTimeoutException(): Boolean {
    val exception = this
    return exception is HttpRequestTimeoutException ||
        exception is ConnectTimeoutException ||
        exception is SocketTimeoutException
}