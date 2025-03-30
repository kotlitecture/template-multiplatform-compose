package kotli.app.showcases.presentation.userflow.loader.advanced

import kotli.app.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object AdvancedLoaderRoute {

    val screen = Showcase.Screen("Advanced Loader", this)

}