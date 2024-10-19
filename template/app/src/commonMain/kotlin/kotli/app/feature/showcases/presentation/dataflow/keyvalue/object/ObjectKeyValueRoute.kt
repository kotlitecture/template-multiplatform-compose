package kotli.app.feature.showcases.presentation.dataflow.keyvalue.`object`

import kotli.app.AppRoute
import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object ObjectKeyValueRoute : AppRoute {

    val screen = Showcase.Screen("Save and restore objects", this)

}