package kotli.app.presentation.showcases.dataflow.cache.basic

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs
import shared.presentation.navigation.NavigationStrategy

object BasicCacheDestination : NavigationDestinationNoArgs() {

    override val id: String = "basic_cache_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { kotli.app.presentation.showcases.dataflow.cache.basic.BasicCacheScreen() }

}