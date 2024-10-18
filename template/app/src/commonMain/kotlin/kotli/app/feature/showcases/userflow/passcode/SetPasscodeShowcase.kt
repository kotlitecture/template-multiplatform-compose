package kotli.app.feature.showcases.userflow.passcode

import kotli.app.feature.passcode.ui.set.SetPasscodeDestination
import kotli.app.feature.showcases.ShowcaseItem
import kotli.app.feature.showcases.ShowcasesViewModel

object SetPasscodeShowcase : kotli.app.feature.showcases.ShowcaseItem {

    override val label: String = "Set Passcode"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(SetPasscodeDestination)
    }

}