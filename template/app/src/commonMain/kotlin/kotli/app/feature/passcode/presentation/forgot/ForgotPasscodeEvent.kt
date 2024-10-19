package kotli.app.feature.passcode.presentation.forgot

sealed class ForgotPasscodeEvent {

    data object Complete : ForgotPasscodeEvent()

}