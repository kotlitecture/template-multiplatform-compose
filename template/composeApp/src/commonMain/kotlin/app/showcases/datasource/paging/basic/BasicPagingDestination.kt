package app.showcases.datasource.paging.basic

import androidx.navigation.NavGraphBuilder
import core.ui.navigation.ArgsStrategy
import core.ui.navigation.NavigationDestination
import core.ui.navigation.NavigationStrategy

object BasicPagingDestination : NavigationDestination<Unit>() {

    override val id: String = "basic_paging_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override val argsStrategy: ArgsStrategy<Unit> = ArgsStrategy.noArgs()
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { BasicPagingScreen() }

}