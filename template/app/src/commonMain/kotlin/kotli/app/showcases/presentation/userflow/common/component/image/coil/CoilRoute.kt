package kotli.app.showcases.presentation.userflow.common.component.image.coil

import kotli.app.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object CoilRoute {

    val screen = Showcase.Screen("Coil Image Library", this)

}