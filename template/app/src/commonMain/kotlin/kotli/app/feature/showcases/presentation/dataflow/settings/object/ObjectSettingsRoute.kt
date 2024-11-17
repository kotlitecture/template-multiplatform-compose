package kotli.app.feature.showcases.presentation.dataflow.settings.`object`

import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object ObjectSettingsRoute {

    val screen = Showcase.Screen("Save and restore objects", this)

}