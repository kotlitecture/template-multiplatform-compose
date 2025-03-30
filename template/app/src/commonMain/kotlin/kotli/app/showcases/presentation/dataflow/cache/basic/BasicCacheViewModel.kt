package kotli.app.showcases.presentation.dataflow.cache.basic

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.flow.collectLatest
import kotlinx.datetime.Clock
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.byUnicodePattern
import shared.data.source.cache.CacheKey
import shared.data.source.cache.CacheSource
import shared.presentation.viewmodel.BaseViewModel

class BasicCacheViewModel(
    private val cacheSource: CacheSource
) : BaseViewModel() {

    private val _state = BasicCacheMutableState()
    val state: BasicCacheState = _state

    override fun doBind() = async("Load data from cache") {
        val cacheKey = SimpleCacheKey("yyyy-MM-dd HH:mm:ss")
        val cacheEntry = cacheSource.get(cacheKey, ::getDateAsFormattedString)
        cacheEntry.changes().collectLatest(_state::cache::set)
    }

    private fun getDateAsFormattedString(key: SimpleCacheKey): String {
        val time = Clock.System.now()
        return time.format(DateTimeComponents.Format {
            byUnicodePattern(key.pattern)
        })
    }

    private data class SimpleCacheKey(
        val pattern: String,
        override val ttl: Long = CacheKey.TTL_10_SECONDS
    ) : CacheKey<String>

    private class BasicCacheMutableState : BasicCacheState {
        override var cache: String? by mutableStateOf(null)
    }

}
