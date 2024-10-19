package kotli.app.feature.showcases.presentation.userflow.loader

import kotli.app.AppRoute
import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object LoaderRoute : AppRoute {

    val screen = Showcase.Screen("Loader", this)

}