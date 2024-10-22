package kotli.app.feature.showcases.presentation.dataflow.http.basic

import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object BasicHttpRoute {

    val screen = Showcase.Screen("Basic Http Usage", this)

}