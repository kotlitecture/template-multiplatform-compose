package kotli.app.feature.showcases.presentation.userflow.theme.toggle

import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object ToggleThemeRoute {

    val screen = Showcase.Screen("Toggle Theme Button", this)

}