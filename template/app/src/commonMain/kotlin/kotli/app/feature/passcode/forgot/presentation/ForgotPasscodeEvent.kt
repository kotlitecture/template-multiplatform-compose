package kotli.app.feature.passcode.forgot.presentation

sealed class ForgotPasscodeEvent {

    data object Complete : ForgotPasscodeEvent()

}