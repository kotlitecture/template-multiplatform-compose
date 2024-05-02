package app.datasource.config

import shared.data.datasource.config.DelegateConfigSource

/**
 * This class represents a configuration source for application settings.
 * It delegates to a FirebaseRemoteConfigSource and provides methods to retrieve various configuration values.
 */
class AppConfigSource : DelegateConfigSource(
    // delegate
) {
    fun getPagingPageSize(): Int = getInt("paging_page_size") { 30 }
    fun getHttpTimeout(): Long = getLong("http_timeout") { 30_000 }
    fun getHttpRetryCount(): Int = getInt("http_retry_count") { 3 }
    fun getDataLoaderDelay(): Long = getLong("data_loader_delay") { 50 }
    fun getDataLoaderTimeout(): Long = getLong("data_loader_timeout") { 30_000 }
}