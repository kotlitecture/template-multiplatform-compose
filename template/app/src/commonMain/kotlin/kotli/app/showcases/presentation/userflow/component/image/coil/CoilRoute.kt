package kotli.app.showcases.presentation.userflow.component.image.coil

import kotli.app.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object CoilRoute {

    val screen = Showcase.Screen("Coil Image Library", this)

}