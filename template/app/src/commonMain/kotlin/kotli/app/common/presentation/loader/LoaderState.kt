package kotli.app.common.presentation.loader

import androidx.compose.runtime.Stable

@Stable
interface LoaderState {

    val loading: Boolean
    val error: Throwable?
    val id: String?

    suspend fun runCatching(label: String, withLoader: Boolean = true, block: suspend () -> Unit)

    fun cancel()

    companion object
}