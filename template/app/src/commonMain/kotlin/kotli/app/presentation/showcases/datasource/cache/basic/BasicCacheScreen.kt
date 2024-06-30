package kotli.app.presentation.showcases.datasource.cache.basic

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotli.app.presentation.showcases.ShowcaseHintBlock
import shared.design.component.AppText
import shared.design.container.AppFixedTopBarColumn
import shared.presentation.viewmodel.provideViewModel
import shared.presentation.store.DataState

@Composable
fun BasicCacheScreen() {
    val viewModel: BasicCacheViewModel = provideViewModel()
    AppFixedTopBarColumn(
        title = BasicCacheShowcase.label,
        onBack = viewModel::onBack,
        content = {
            ShowcaseHintBlock(
                text = """
                    This showcase demonstrates the simple usage of the Cache API.

                    It caches the current time and stores it for 10 seconds.
                    
                    You can navigate back and forth to this screen, but once 10 seconds have passed, the cache is updated with the new value.
                """.trimIndent()
            )
            CacheBlock(viewModel.cacheState)
        }
    )
}

@Composable
private fun CacheBlock(store: DataState<String>) {
    AppText(
        modifier = Modifier.padding(horizontal = 16.dp),
        text = "Current cache value : ${store.asStateValue()}"
    )
}