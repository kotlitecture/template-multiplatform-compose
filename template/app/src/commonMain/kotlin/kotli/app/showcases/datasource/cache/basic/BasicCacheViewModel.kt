package kotli.app.showcases.datasource.cache.basic

import kotlinx.coroutines.flow.collectLatest
import kotlinx.datetime.Clock
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.byUnicodePattern
import shared.data.datasource.cache.CacheKey
import shared.data.datasource.cache.CacheSource
import shared.presentation.BaseViewModel
import shared.presentation.navigation.NavigationState
import shared.presentation.state.StoreObject

class BasicCacheViewModel(
    private val navigationState: NavigationState,
    private val cacheSource: CacheSource
) : BaseViewModel() {

    val cacheStore = StoreObject<String>()

    fun onBack() = navigationState.onBack()

    override fun doBind() {
        launchAsync {
            val cacheKey = SimpleCacheKey()
            val cacheEntry = cacheSource.get(cacheKey, ::getDateAsFormattedString)
            cacheEntry.changes().collectLatest(cacheStore::set)
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
