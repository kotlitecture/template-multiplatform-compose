package kotli.app.showcases.presentation.userflow.theme.toggle

import androidx.compose.foundation.layout.sizeIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotli.app.theme.toggle.presentation.ToggleThemeButton
import shared.presentation.ui.component.AppDialogContent

@Composable
fun ToggleThemeScreen() {
    AppDialogContent(
        modifier = Modifier
            .sizeIn(
                minWidth = 100.dp,
                minHeight = 100.dp
            )
    ) {
        ToggleThemeButton()
    }
}

