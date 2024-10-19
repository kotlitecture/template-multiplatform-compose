package kotli.app.feature.showcases.presentation.userflow.passcode

import kotli.app.feature.passcode.presentation.reset.ResetPasscodeRoute
import kotli.app.feature.passcode.presentation.set.SetPasscodeRoute
import kotli.app.feature.showcases.domain.Showcase

object PasscodeShowcases {

    val reset = Showcase.Screen("Reset Passcode", ResetPasscodeRoute)
    val set = Showcase.Screen("Set Passcode", SetPasscodeRoute)

}