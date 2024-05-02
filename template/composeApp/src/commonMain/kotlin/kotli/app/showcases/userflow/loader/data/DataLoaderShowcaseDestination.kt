package kotli.app.showcases.userflow.loader.data

import androidx.navigation.NavGraphBuilder
import shared.core.navigation.NavigationDestinationNoArgs
import shared.core.navigation.NavigationStrategy

object DataLoaderShowcaseDestination : NavigationDestinationNoArgs() {

    override val id: String = "data_loader_showcase_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { DataLoaderShowcaseScreen() }

}