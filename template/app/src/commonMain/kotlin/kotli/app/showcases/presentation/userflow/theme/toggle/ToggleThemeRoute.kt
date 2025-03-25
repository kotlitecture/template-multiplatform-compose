package kotli.app.showcases.presentation.userflow.theme.toggle

import kotli.app.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object ToggleThemeRoute {

    val screen = Showcase.Screen("Toggle Theme Button", this)

}