package kotli.app.feature.showcases.userflow.component.placeholder

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs
import shared.presentation.navigation.NavigationStrategy

object PlaceholderShowcaseDestination : NavigationDestinationNoArgs() {

    override val id: String = "placeholder_showcase_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) =
        composable(builder) { PlaceholderShowcaseScreen() }

}