package kotli.app.showcases.presentation.userflow.common.component.image.coil

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import kotli.app.showcases.presentation.ShowcaseHintBlock
import shared.presentation.ui.component.DsIcon
import shared.presentation.ui.container.DsFixedTopBarLazyColumn
import shared.presentation.ui.icon.DsIconModel
import shared.presentation.ui.theme.DsTheme
import kotlin.random.Random

@Composable
fun CoilScreen(onBack: () -> Unit) {
    DsFixedTopBarLazyColumn(
        title = CoilRoute.screen.label,
        onBack = onBack,
        content = {
            item {
                ShowcaseHintBlock(
                    text = """
                    This showcase demonstrates the usage of the Coil Image library to show images and icons loaded via HTTP.
                """.trimIndent()
                )
            }

            repeat(50) { idx ->
                item {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        DsIcon(
                            size = (64 + Random.nextInt(340)).dp,
                            modifier = Modifier
                                .padding(8.dp)
                                .clip(RoundedCornerShape(Random.nextInt(50)))
                                .background(DsTheme.current.highlightPrimary),
                            model = DsIconModel.Url("https://picsum.photos/id/${idx + 1}/200/300")
                        )
                    }
                }
            }
        }
    )
}