package kotli.app.feature.showcases.presentation.dataflow.http.basic

import kotli.app.AppRoute
import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object BasicHttpRoute : AppRoute {

    val screen = Showcase.Screen("Basic Http Usage", this)

}