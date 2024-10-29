package kotli.app.feature.showcases.presentation.userflow.loader.basic

import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object BasicLoaderRoute {

    val screen = Showcase.Screen("Basic Loader", this)

}