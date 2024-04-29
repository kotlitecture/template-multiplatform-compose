package app.showcases.navigation.args.from

import androidx.navigation.NavGraphBuilder
import shared.core.navigation.NavigationDestinationNoArgs
import shared.core.navigation.NavigationStrategy

object ArgsNavigationFromDestination : NavigationDestinationNoArgs() {

    override val id: String = "navigation_args_from_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { ArgsNavigationFromScreen() }

}