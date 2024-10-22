package kotli.app.feature.showcases.presentation.dataflow.sqldelight.crud

import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object SqlDelightCrudRoute {

    val screen = Showcase.Screen("SqlDelight CRUD", this)

}