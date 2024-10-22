package kotli.app.feature.showcases.presentation.userflow.component.placeholder

import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object PlaceholderRoute {

    val screen = Showcase.Screen("Placeholders", this)

}