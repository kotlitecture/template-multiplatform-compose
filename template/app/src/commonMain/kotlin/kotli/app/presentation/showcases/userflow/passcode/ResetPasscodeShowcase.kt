package kotli.app.presentation.showcases.userflow.passcode

import kotli.app.feature.passcode.ui.reset.ResetPasscodeDestination
import kotli.app.presentation.showcases.ShowcaseItem
import kotli.app.presentation.showcases.ShowcasesViewModel

object ResetPasscodeShowcase : ShowcaseItem {

    override val label: String = "Reset Passcode"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(ResetPasscodeDestination)
    }

}