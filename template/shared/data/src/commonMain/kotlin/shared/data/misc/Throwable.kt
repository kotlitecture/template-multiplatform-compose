package shared.data.misc

import kotlinx.coroutines.CancellationException

fun Throwable.isCancellationException(): Boolean {
    var exception: Throwable? = this
    while (exception != null && exception !is CancellationException) {
        if (exception == exception.cause) return false
        exception = exception.cause
    }
    return exception is CancellationException
}