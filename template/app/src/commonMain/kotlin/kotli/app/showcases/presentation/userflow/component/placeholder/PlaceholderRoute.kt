package kotli.app.showcases.presentation.userflow.component.placeholder

import kotli.app.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object PlaceholderRoute {

    val screen = Showcase.Screen("Placeholders", this)

}