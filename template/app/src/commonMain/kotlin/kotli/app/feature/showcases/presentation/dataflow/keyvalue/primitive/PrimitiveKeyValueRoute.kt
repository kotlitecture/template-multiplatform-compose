package kotli.app.feature.showcases.presentation.dataflow.keyvalue.primitive

import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object PrimitiveKeyValueRoute {

    val screen = Showcase.Screen("Save and restore primitives", this)

}