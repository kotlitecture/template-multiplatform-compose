package kotli.app.feature.passcode.presentation.reset

sealed class ResetPasscodeEvent {

    data object Complete : ResetPasscodeEvent()

}