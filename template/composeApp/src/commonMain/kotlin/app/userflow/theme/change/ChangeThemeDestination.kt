package app.userflow.theme.change

import androidx.navigation.NavGraphBuilder
import core.ui.navigation.NavigationDestinationNoArgs
import core.ui.navigation.NavigationStrategy

/**
 * Navigation destination for changing the theme.
 */
object ChangeThemeDestination : NavigationDestinationNoArgs() {

    override val id: String = "change_theme_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { ChangeThemeScreen() }

}