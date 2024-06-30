package kotli.app.presentation.showcases.dataflow.cache.basic

import kotlinx.coroutines.flow.collectLatest
import kotlinx.datetime.Clock
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.byUnicodePattern
import shared.data.source.cache.CacheKey
import shared.data.source.cache.CacheSource
import shared.presentation.navigation.NavigationStore
import shared.presentation.store.DataState
import shared.presentation.viewmodel.BaseViewModel

class BasicCacheViewModel(
    private val navigationStore: NavigationStore,
    private val cacheSource: CacheSource
) : BaseViewModel() {

    val cacheState = DataState<String>()

    fun onBack() = navigationStore.onBack()

    override fun doBind() {
        launchAsync {
            val cacheKey = SimpleCacheKey()
            val cacheEntry = cacheSource.get(cacheKey, ::getDateAsFormattedString)
            cacheEntry.changes().collectLatest(cacheState::set)
        }
    }

    private fun getDateAsFormattedString(): String {
        val time = Clock.System.now()
        return time.format(DateTimeComponents.Format {
            byUnicodePattern("yyyy-MM-dd HH:mm:ss")
        })
    }

    private data class SimpleCacheKey(
        override val ttl: Long = CacheKey.TTL_10_SECONDS
    ) : CacheKey<String>

}
