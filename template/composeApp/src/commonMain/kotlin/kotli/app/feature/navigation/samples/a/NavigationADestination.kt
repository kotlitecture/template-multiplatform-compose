package kotli.app.feature.navigation.samples.a

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationStrategy
import shared.presentation.navigation.NavigationDestinationNoArgs

object NavigationADestination : NavigationDestinationNoArgs() {

    override val id: String = "navigation_a_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.SingleInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { NavigationAScreen() }

}