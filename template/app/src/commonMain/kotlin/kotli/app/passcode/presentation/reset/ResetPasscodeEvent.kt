package kotli.app.passcode.presentation.reset

sealed class ResetPasscodeEvent {

    data object Complete : ResetPasscodeEvent()

}