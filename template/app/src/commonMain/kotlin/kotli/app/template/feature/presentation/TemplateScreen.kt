package kotli.app.template.feature.presentation

import androidx.compose.runtime.Composable
import shared.presentation.ui.container.DsFixedTopBarLayout

@Composable
fun TemplateScreen(
    title: String,
    onBack: () -> Unit
) {
    DsFixedTopBarLayout(
        title = title,
        onBack = onBack,
    ) {
        //
    }
}