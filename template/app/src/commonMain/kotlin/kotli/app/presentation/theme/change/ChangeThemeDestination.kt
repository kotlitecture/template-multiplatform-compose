package kotli.app.presentation.theme.change

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs
import shared.presentation.navigation.NavigationStrategy

/**
 * Navigation destination for changing the theme.
 */
object ChangeThemeDestination : NavigationDestinationNoArgs() {

    override val id: String = "change_theme_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { ChangeThemeScreen() }

}