package kotli.app.presentation.showcases.userflow.theme.toggle

import androidx.compose.foundation.layout.sizeIn
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import kotli.app.theme.toggle.presentation.ToggleThemeButton
import shared.design.component.AppDialogContent
import shared.presentation.navigation.NavigationDestinationNoArgs

object ToggleThemeDestination : NavigationDestinationNoArgs() {

    override val id: String = "toggle_theme_dialog"

    override fun doBind(builder: NavGraphBuilder) = dialog(builder) {
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
}