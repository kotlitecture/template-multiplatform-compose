package shared.core.state

import kotlinx.datetime.Clock

/**
 * Represents the state of data loading.
 */
sealed class DataState {

    val uid = Clock.System.now().nanosecondsOfSecond

    data class Loading(
        val id: String
    ) : DataState()

    data class Loaded(
        val id: String
    ) : DataState()

    data class Error(
        val id: String,
        val th: Throwable
    ) : DataState()
}