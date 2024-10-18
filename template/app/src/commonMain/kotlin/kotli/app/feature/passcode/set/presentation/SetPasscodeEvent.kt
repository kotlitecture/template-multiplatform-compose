package kotli.app.feature.passcode.set.presentation

sealed class SetPasscodeEvent {

    data object Complete : SetPasscodeEvent()

}