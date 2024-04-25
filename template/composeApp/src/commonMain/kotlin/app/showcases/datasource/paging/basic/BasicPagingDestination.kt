package app.showcases.datasource.paging.basic

import androidx.navigation.NavGraphBuilder
import core.ui.navigation.NavigationDestinationNoArgs
import core.ui.navigation.NavigationStrategy

object BasicPagingDestination : NavigationDestinationNoArgs() {

    override val id: String = "basic_paging_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { BasicPagingScreen() }

}