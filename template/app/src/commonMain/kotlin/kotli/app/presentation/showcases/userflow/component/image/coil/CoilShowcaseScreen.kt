package kotli.app.presentation.showcases.userflow.component.image.coil

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import kotli.app.presentation.showcases.ShowcaseHintBlock
import shared.design.component.AppIcon
import shared.design.container.AppFixedTopBarColumn
import shared.design.icon.UrlModel
import shared.design.theme.AppTheme
import shared.presentation.viewmodel.provideViewModel
import kotlin.random.Random

@Composable
fun CoilShowcaseScreen() {
    val viewModel: CoilShowcaseViewModel = provideViewModel()
    AppFixedTopBarColumn(
        title = CoilShowcase.label,
        onBack = viewModel::onBack,
        content = {
            ShowcaseHintBlock(
                text = """
                    This showcase demonstrates the usage of the Coil Image library to show images and icons loaded via HTTP.
                """.trimIndent()
            )

            repeat(50) { idx ->
                AppIcon(
                    size = (64 + Random.nextInt(340)).dp,
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(Random.nextInt(50)))
                        .align(Alignment.CenterHorizontally)
                        .background(AppTheme.current.highlightPrimary),
                    model = UrlModel("https://picsum.photos/id/${idx + 1}/200/300")
                )
            }
        }
    )
}