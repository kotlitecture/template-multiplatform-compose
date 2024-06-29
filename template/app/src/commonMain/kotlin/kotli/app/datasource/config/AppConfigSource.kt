package kotli.app.datasource.config

import shared.data.source.config.DelegateConfigSource

/**
 * This class represents a configuration source for application settings.
 * It delegates to an underlining source and provides methods to retrieve various configuration values
 * without keys passed.
 */
class AppConfigSource : DelegateConfigSource(
    // delegate
) {
    fun getPagingPageSize(): Int = getInt("paging_page_size") { 30 }
    fun getHttpTimeout(): Long = getLong("http_timeout") { 30_000 }
    fun getHttpRetryCount(): Int = getInt("http_retry_count") { 3 }
    fun getUiLoaderDelay(): Long = getLong("ui_loader_delay") { 50 }
    fun getUiLoaderTimeout(): Long = getLong("ui_loader_timeout") { 30_000 }
}