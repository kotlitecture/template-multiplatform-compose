package kotli.app.showcases.presentation.userflow.loader.basic

import kotli.app.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object BasicLoaderRoute {

    val screen = Showcase.Screen("Basic Loader", this)

}