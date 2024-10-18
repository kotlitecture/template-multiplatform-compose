package kotli.app.presentation.showcases.userflow.passcode

import kotli.app.feature.passcode.ui.set.SetPasscodeDestination
import kotli.app.presentation.showcases.ShowcaseItem
import kotli.app.presentation.showcases.ShowcasesViewModel

object SetPasscodeShowcase : ShowcaseItem {

    override val label: String = "Set Passcode"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(SetPasscodeDestination)
    }

}