package shared.design.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import com.mikepenz.markdown.coil3.Coil3ImageTransformerImpl
import com.mikepenz.markdown.compose.Markdown
import com.mikepenz.markdown.m3.markdownColor
import com.mikepenz.markdown.m3.markdownTypography

@Composable
@NonRestartableComposable
fun AppMarkdown(
    modifier: Modifier = Modifier,
    text: String
) {
    Markdown(
        modifier = modifier,
        content = text,
        imageTransformer = Coil3ImageTransformerImpl,
        typography = markdownTypography(),
        colors = markdownColor(),
    )
}