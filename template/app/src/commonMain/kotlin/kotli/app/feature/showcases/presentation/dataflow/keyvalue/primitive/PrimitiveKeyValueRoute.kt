package kotli.app.feature.showcases.presentation.dataflow.keyvalue.primitive

import kotli.app.AppRoute
import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object PrimitiveKeyValueRoute : AppRoute {

    val screen = Showcase.Screen("Save and restore primitives", this)

}