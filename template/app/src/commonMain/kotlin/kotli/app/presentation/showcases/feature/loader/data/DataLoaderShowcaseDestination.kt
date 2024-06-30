package kotli.app.presentation.showcases.feature.loader.data

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs
import shared.presentation.navigation.NavigationStrategy

object DataLoaderShowcaseDestination : NavigationDestinationNoArgs() {

    override val id: String = "data_loader_showcase_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { DataLoaderShowcaseScreen() }

}