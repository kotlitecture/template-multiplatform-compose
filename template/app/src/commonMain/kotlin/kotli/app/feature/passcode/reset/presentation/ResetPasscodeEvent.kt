package kotli.app.feature.passcode.reset.presentation

sealed class ResetPasscodeEvent {

    data object Complete : ResetPasscodeEvent()

}