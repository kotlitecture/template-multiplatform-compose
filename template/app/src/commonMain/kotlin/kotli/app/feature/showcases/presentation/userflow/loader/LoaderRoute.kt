package kotli.app.feature.showcases.presentation.userflow.loader

import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object LoaderRoute {

    val screen = Showcase.Screen("Loader", this)

}