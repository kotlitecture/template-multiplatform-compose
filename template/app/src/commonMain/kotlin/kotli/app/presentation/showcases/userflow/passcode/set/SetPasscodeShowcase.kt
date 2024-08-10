package kotli.app.presentation.showcases.userflow.passcode.set

import kotli.app.presentation.passcode.ui.set.enter.EnterPasscodeDestination
import kotli.app.presentation.showcases.ShowcaseItem
import kotli.app.presentation.showcases.ShowcasesViewModel

object SetPasscodeShowcase : ShowcaseItem {

    override val label: String = "Set Passcode"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(EnterPasscodeDestination)
    }

}