package kotli.app.showcases.presentation.userflow.passcode

import kotli.app.passcode.presentation.reset.ResetPasscodeRoute
import kotli.app.passcode.presentation.set.SetPasscodeRoute
import kotli.app.showcases.domain.Showcase

object PasscodeShowcases {

    val reset = Showcase.Screen("Reset Passcode", ResetPasscodeRoute)
    val set = Showcase.Screen("Set Passcode", SetPasscodeRoute)

}