package kotli.app.showcases.navigation.no_args.to

import androidx.navigation.NavGraphBuilder
import shared.core.navigation.NavigationDestinationNoArgs
import shared.core.navigation.NavigationStrategy

object NoArgsNavigationToDestination : NavigationDestinationNoArgs() {

    override val id: String = "navigation_no_args_to_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { NoArgsNavigationToScreen() }

}