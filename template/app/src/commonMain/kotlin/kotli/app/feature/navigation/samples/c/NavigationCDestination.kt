package kotli.app.feature.navigation.samples.c

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationStrategy
import shared.presentation.navigation.NavigationDestinationNoArgs

object NavigationCDestination : NavigationDestinationNoArgs() {

    override val id: String = "navigation_c_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.SingleInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { NavigationCScreen() }

}