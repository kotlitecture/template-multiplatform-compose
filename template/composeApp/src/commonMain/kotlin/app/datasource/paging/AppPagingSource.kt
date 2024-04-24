package app.datasource.paging

import app.cash.paging.Pager
import app.cash.paging.PagingSource
import app.cash.paging.createPager
import app.cash.paging.createPagingConfig

/**
 * This class represents a paging source for use with Jetpack Paging.
 * It provides a method to create a Pager instance with a specified page size.
 */
class AppPagingSource(private val pageSize: Int) {

    /**
     * Creates a Pager instance with the given paging source factory.
     *
     * @param <K> The type of keys used to load pages.
     * @param <V> The type of items loaded by the paging source.
     * @param pagingSourceFactory A lambda function that creates a PagingSource instance.
     * @return A Pager instance configured with the specified page size and paging source factory.
     */
    fun <K : Any, V : Any> getPager(pagingSourceFactory: () -> PagingSource<K, V>): Pager<K, V> {
        return createPager(
            config = createPagingConfig(
                pageSize = pageSize,
                enablePlaceholders = false
            ),
            pagingSourceFactory = pagingSourceFactory
        )
    }

}