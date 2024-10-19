package kotli.app.feature.showcases.presentation.dataflow.room.crud

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs
import shared.presentation.navigation.NavigationStrategy

object RoomCrudDestination : NavigationDestinationNoArgs() {

    override val id: String = "room_crud_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { RoomCrudScreen() }

}