package kotli.app.showcases.presentation.dataflow.cache.basic

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotli.app.showcases.presentation.ShowcaseHintBlock
import shared.presentation.ui.component.AppText
import shared.presentation.ui.container.AppFixedTopBarColumn
import shared.presentation.viewmodel.provideViewModel

@Composable
fun BasicCacheScreen(onBack: () -> Unit) {
    val viewModel: BasicCacheViewModel = provideViewModel()

    AppFixedTopBarColumn(
        title = BasicCacheRoute.screen.label,
        onBack = onBack,
        content = {
            ShowcaseHintBlock(
                text = """
                    This showcase demonstrates the simple usage of the Cache API.

                    It caches the current time and stores it for 10 seconds.
                    
                    You can navigate back and forth to this screen, but once 10 seconds have passed, the cache is updated with the new value.
                """.trimIndent()
            )
            CacheBlock(viewModel.state)
        }
    )
}

@Composable
private fun CacheBlock(state: BasicCacheState) {
    AppText(
        modifier = Modifier.padding(horizontal = 16.dp),
        text = "Current cache value : ${state.cache}"
    )
}