package kotli.app.showcases.presentation.dataflow.sqldelight.crud

import kotli.app.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object SqlDelightCrudRoute {

    val screen = Showcase.Screen("SqlDelight CRUD", this)

}