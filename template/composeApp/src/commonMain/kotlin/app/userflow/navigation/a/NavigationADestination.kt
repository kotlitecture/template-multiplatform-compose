package app.userflow.navigation.a

import androidx.navigation.NavGraphBuilder
import core.ui.navigation.NavigationStrategy
import core.ui.navigation.NavigationDestinationNoArgs

object NavigationADestination : NavigationDestinationNoArgs() {

    override val id: String = "navigation_a_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.SingleInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { NavigationAScreen() }

}