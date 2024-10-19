package kotli.app.feature.showcases.presentation.dataflow.paging.basic

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs
import shared.presentation.navigation.NavigationStrategy

object BasicPagingDestination : NavigationDestinationNoArgs() {

    override val id: String = "basic_paging_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { BasicPagingScreen() }

}