package kotli.app.presentation.theme.change

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs

/**
 * Navigation destination for changing the theme.
 */
object ChangeThemeDestination : NavigationDestinationNoArgs() {

    override val id: String = "change_theme_screen"
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { ChangeThemeScreen() }

}