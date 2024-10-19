package kotli.app.feature.passcode.presentation.set

sealed class SetPasscodeEvent {

    data object Complete : SetPasscodeEvent()

}