package kotli.app.feature.showcases.presentation.dataflow.room.crud

import kotli.app.AppRoute
import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object RoomCrudRoute : AppRoute {

    val screen = Showcase.Screen("Room CRUD", this)

}