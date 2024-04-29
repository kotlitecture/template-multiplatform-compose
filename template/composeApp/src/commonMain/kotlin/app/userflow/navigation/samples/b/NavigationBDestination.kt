package app.userflow.navigation.samples.b

import androidx.navigation.NavGraphBuilder
import core.ui.navigation.NavigationStrategy
import core.ui.navigation.NavigationDestinationNoArgs

object NavigationBDestination : NavigationDestinationNoArgs() {

    override val id: String = "navigation_b_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.SingleInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { NavigationBScreen() }

}