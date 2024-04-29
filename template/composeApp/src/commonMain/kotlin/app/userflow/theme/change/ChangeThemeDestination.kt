package app.userflow.theme.change

import androidx.navigation.NavGraphBuilder
import shared.core.navigation.NavigationDestinationNoArgs
import shared.core.navigation.NavigationStrategy

/**
 * Navigation destination for changing the theme.
 */
object ChangeThemeDestination : NavigationDestinationNoArgs() {

    override val id: String = "change_theme_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { ChangeThemeScreen() }

}