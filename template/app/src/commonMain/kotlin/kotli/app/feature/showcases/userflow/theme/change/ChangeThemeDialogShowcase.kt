package kotli.app.feature.showcases.userflow.theme.change

import kotli.app.feature.showcases.ShowcaseItem
import kotli.app.feature.showcases.ShowcasesViewModel
import kotli.app.feature.theme.change.presentation.ChangeThemeDialogDestination

/**
 * Showcase item representing a change theme dialog.
 * This showcase item demonstrates the functionality of changing the theme via a dialog.
 */
object ChangeThemeDialogShowcase : kotli.app.feature.showcases.ShowcaseItem {

    override val label: String = "Change Theme Dialog"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(ChangeThemeDialogDestination)
    }

}