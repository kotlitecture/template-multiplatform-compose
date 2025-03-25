package kotli.app.common

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.lifecycle.viewmodel.initializer
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import kotli.app.common.presentation.loader.LoaderViewModel
import org.koin.dsl.module
import shared.data.source.ai.AiSource
import shared.data.source.ai.gemini.GeminiAiSource
import shared.data.source.analytics.AnalyticsSource
import shared.data.source.analytics.BasicAnalyticsSource
import shared.data.source.cache.BasicCacheSource
import shared.data.source.cache.CacheSource
import shared.data.source.config.BasicConfigSource
import shared.data.source.config.ConfigSource
import shared.data.source.encryption.EncryptionSource
import shared.data.source.encryption.korlibs.KorlibsEncryptionSource
import shared.data.source.http.HttpSource
import shared.data.source.paging.PagingSource
import shared.data.source.paging.multiplatform.MultiplatformPagingSource
import shared.data.source.settings.SettingsSource
import shared.data.source.settings.multiplatform.MultiplatformSettingsSource

fun NavGraphBuilder.common(navController: NavHostController) = Unit

fun InitializerViewModelFactoryBuilder.common() {
    initializer { LoaderViewModel() }
}

val common = module {
    single { HttpSource() }
    single<AiSource> { GeminiAiSource() }
    single<CacheSource> { BasicCacheSource() }
    single<ConfigSource> { BasicConfigSource() }
    single<AnalyticsSource> { BasicAnalyticsSource() }
    single<PagingSource> { MultiplatformPagingSource() }
    single<EncryptionSource> { KorlibsEncryptionSource() }
    single<SettingsSource> { MultiplatformSettingsSource() }
}