package kotli.app.feature.passcode.ui.forgot

import kotli.app.feature.passcode.usecase.ForgotPasscode
import shared.presentation.store.DataState
import shared.presentation.viewmodel.BaseViewModel

class ForgotPasscodeViewModel(
    private val forgotPasscode: ForgotPasscode
) : BaseViewModel() {

    fun onConfirm(state: DataState<Boolean>) {
        async("Reset passcode") {
            forgotPasscode.invoke()
            state.set(false)
        }
    }

}
