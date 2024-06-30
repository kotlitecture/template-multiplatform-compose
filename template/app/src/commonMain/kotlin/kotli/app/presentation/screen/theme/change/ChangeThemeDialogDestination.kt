package kotli.app.presentation.screen.theme.change

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs
import shared.presentation.navigation.NavigationStrategy

/**
 * Navigation destination for the change theme dialog screen.
 */
object ChangeThemeDialogDestination : NavigationDestinationNoArgs() {

    override val id: String = "change_theme_dialog_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = dialog(builder) { ChangeThemeDialog() }

}