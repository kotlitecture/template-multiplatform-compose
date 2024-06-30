package kotli.app.presentation.navigation.samples.b

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationStrategy
import shared.presentation.navigation.NavigationDestinationNoArgs

object NavigationBDestination : NavigationDestinationNoArgs() {

    override val id: String = "navigation_b_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.SingleInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { NavigationBScreen() }

}