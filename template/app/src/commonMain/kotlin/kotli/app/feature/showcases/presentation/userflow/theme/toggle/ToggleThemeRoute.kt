package kotli.app.feature.showcases.presentation.userflow.theme.toggle

import kotli.app.AppRoute
import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object ToggleThemeRoute : AppRoute {

    val screen = Showcase.Screen("Toggle Theme Button", this)

}