package kotli.app.presentation.passcode.ui.forgot

import kotli.app.presentation.passcode.model.PasscodeStore
import kotli.app.presentation.passcode.usecase.ForgotPasscode
import shared.presentation.store.DataState
import shared.presentation.viewmodel.BaseViewModel

class ForgotPasscodeViewModel(
    private val passcodeStore: PasscodeStore,
    private val forgotPasscode: ForgotPasscode
) : BaseViewModel() {

    fun onConfirm(state: DataState<Boolean>) {
        launchAsync("Reset passcode", passcodeStore) {
            forgotPasscode.invoke()
            state.set(false)
        }
    }

}
