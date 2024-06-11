package kotli.app.showcases.navigation.no_args.from

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs
import shared.presentation.navigation.NavigationStrategy

object NoArgsNavigationFromDestination : NavigationDestinationNoArgs() {

    override val id: String = "navigation_no_args_from_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { NoArgsNavigationFromScreen() }

}