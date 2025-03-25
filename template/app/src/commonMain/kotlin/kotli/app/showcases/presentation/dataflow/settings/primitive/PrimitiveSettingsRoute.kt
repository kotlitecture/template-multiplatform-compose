package kotli.app.showcases.presentation.dataflow.settings.primitive

import kotli.app.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object PrimitiveSettingsRoute {

    val screen = Showcase.Screen("Save and restore primitives", this)

}