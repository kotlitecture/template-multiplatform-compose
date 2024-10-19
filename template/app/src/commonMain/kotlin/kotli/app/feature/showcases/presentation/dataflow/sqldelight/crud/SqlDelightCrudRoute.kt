package kotli.app.feature.showcases.presentation.dataflow.sqldelight.crud

import kotli.app.AppRoute
import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object SqlDelightCrudRoute : AppRoute {

    val screen = Showcase.Screen("SqlDelight CRUD", this)

}