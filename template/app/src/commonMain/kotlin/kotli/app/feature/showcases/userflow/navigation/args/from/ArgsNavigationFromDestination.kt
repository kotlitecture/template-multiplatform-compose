package kotli.app.feature.showcases.userflow.navigation.args.from

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs
import shared.presentation.navigation.NavigationStrategy

object ArgsNavigationFromDestination : NavigationDestinationNoArgs() {

    override val id: String = "navigation_args_from_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { ArgsNavigationFromScreen() }

}