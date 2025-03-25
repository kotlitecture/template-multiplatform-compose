package kotli.app.showcases.presentation.dataflow.http.basic

import kotli.app.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object BasicHttpRoute {

    val screen = Showcase.Screen("Basic Http Usage", this)

}