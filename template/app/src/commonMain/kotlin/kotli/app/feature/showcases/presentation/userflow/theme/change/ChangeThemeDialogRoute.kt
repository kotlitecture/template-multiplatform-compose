package kotli.app.feature.showcases.presentation.userflow.theme.change

import kotli.app.AppRoute
import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object ChangeThemeDialogRoute: AppRoute {

    val screen = Showcase.Screen("Change Theme Dialog", this)

}