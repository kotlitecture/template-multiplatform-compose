package kotli.app.template.feature.presentation

import androidx.compose.runtime.Composable
import shared.presentation.ui.container.AppFixedTopBarLayout

@Composable
fun TemplateScreen(
    title: String,
    onBack: () -> Unit
) {
    AppFixedTopBarLayout(
        title = title,
        onBack = onBack,
    ) {
        //
    }
}