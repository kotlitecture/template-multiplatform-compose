package kotli.app.feature.showcases.presentation.userflow.passcode

import kotli.app.AppRoute
import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object ResetPasscodeRoute:AppRoute {

    val screen = Showcase.Screen("Reset Passcode", this)

}