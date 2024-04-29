package app.userflow.navigation.samples.a

import androidx.navigation.NavGraphBuilder
import shared.core.navigation.NavigationStrategy
import shared.core.navigation.NavigationDestinationNoArgs

object NavigationADestination : NavigationDestinationNoArgs() {

    override val id: String = "navigation_a_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.SingleInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { NavigationAScreen() }

}