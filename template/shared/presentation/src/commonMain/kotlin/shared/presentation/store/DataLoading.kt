package shared.presentation.store

import kotlinx.datetime.Clock

/**
 * Represents the data loading states.
 */
sealed class DataLoading {

    val uid = Clock.System.now().nanosecondsOfSecond

    data class InProgress(
        val id: String?
    ) : DataLoading()

    data class Loaded(
        val id: String?
    ) : DataLoading()

    data class Error(
        val id: String?,
        val th: Throwable
    ) : DataLoading()
}