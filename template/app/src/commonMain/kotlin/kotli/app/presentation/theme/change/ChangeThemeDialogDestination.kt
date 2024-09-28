package kotli.app.presentation.theme.change

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs

/**
 * Navigation destination for the change theme dialog screen.
 */
object ChangeThemeDialogDestination : NavigationDestinationNoArgs() {

    override val id: String = "change_theme_dialog"
    override fun doBind(builder: NavGraphBuilder) = dialog(builder) { ChangeThemeDialog() }

}