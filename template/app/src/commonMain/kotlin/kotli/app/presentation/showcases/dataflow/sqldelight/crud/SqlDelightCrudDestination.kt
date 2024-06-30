package kotli.app.presentation.showcases.dataflow.sqldelight.crud

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs
import shared.presentation.navigation.NavigationStrategy

object SqlDelightCrudDestination : NavigationDestinationNoArgs() {

    override val id: String = "sql_delight_crud_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { SqlDelightCrudScreen() }

}