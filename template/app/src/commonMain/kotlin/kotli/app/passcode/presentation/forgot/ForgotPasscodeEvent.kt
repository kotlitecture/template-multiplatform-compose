package kotli.app.passcode.presentation.forgot

sealed class ForgotPasscodeEvent {

    data object Complete : ForgotPasscodeEvent()

}