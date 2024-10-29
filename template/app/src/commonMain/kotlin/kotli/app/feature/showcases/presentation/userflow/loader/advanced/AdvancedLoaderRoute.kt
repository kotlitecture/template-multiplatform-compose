package kotli.app.feature.showcases.presentation.userflow.loader.advanced

import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object AdvancedLoaderRoute {

    val screen = Showcase.Screen("Advanced Loader", this)

}