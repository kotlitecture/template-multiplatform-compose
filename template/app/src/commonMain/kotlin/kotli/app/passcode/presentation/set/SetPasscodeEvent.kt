package kotli.app.passcode.presentation.set

sealed class SetPasscodeEvent {

    data object Complete : SetPasscodeEvent()

}