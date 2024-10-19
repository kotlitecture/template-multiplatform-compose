package kotli.app.feature.showcases.presentation.dataflow.sqldelight.paging

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs
import shared.presentation.navigation.NavigationStrategy

object SqlDelightPagingDestination : NavigationDestinationNoArgs() {

    override val id: String = "sql_delight_paging_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { SqlDelightPagingScreen() }

}