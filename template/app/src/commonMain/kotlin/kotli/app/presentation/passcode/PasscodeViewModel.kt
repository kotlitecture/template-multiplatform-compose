package kotli.app.presentation.passcode

import shared.presentation.navigation.NavigationStore
import shared.presentation.viewmodel.BaseViewModel

class PasscodeViewModel(
    private val navigationStore: NavigationStore,
    private val passcodeStore: PasscodeStore
) : BaseViewModel() {

    override fun doBind() {
        println("DO BIND :: $this")
        super.doBind()
    }

    override fun doResume() {
        println("DO RESUME :: $this")
        super.doResume()
    }

    override fun doPause() {
        println("DO PAUSE :: $this")
        super.doPause()
    }

}
