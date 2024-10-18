package kotli.app.feature.theme.change.presentation

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs

object ChangeThemeDialogDestination : NavigationDestinationNoArgs() {

    override val id: String = "change_theme_dialog"
    override fun doBind(builder: NavGraphBuilder) = dialog(builder) { ChangeThemeDialog() }

}