package kotli.app.showcases.presentation.dataflow.room.paging

import kotli.app.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object RoomPagingRoute {

    val screen = Showcase.Screen("Room Paging", this)

}