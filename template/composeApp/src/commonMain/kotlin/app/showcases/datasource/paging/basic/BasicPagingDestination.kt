package app.showcases.datasource.paging.basic

import androidx.navigation.NavGraphBuilder
import shared.core.navigation.NavigationDestinationNoArgs
import shared.core.navigation.NavigationStrategy

object BasicPagingDestination : NavigationDestinationNoArgs() {

    override val id: String = "basic_paging_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { BasicPagingScreen() }

}