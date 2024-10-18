package kotli.app.feature.showcases.userflow.passcode

import kotli.app.feature.passcode.ui.reset.ResetPasscodeDestination
import kotli.app.feature.showcases.ShowcaseItem
import kotli.app.feature.showcases.ShowcasesViewModel

object ResetPasscodeShowcase : kotli.app.feature.showcases.ShowcaseItem {

    override val label: String = "Reset Passcode"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(ResetPasscodeDestination)
    }

}