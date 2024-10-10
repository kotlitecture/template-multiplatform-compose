package kotli.app.presentation.showcases.userflow.theme.change

import kotli.app.presentation.showcases.ShowcaseItem
import kotli.app.presentation.showcases.ShowcasesViewModel
import kotli.app.theme.change.presentation.ChangeThemeDialogDestination

/**
 * Showcase item representing a change theme dialog.
 * This showcase item demonstrates the functionality of changing the theme via a dialog.
 */
object ChangeThemeDialogShowcase : ShowcaseItem {

    override val label: String = "Change Theme Dialog"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(ChangeThemeDialogDestination)
    }

}