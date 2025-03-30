package shared.data.source.paging

fun interface PageLoader<V> {

    suspend fun load(limit: Int, offset: Int): List<V>
}