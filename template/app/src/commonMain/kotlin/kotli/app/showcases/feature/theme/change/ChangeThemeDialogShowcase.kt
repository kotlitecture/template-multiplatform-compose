package kotli.app.showcases.feature.theme.change

import kotli.app.showcases.ShowcaseItem
import kotli.app.showcases.ShowcasesViewModel
import kotli.app.feature.theme.change.ChangeThemeDialogDestination

/**
 * Showcase item representing a change theme dialog.
 * This showcase item demonstrates the functionality of changing the theme via a dialog.
 */
object ChangeThemeDialogShowcase : ShowcaseItem {

    override val label: String = "Change Theme Dialog"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationState.onNext(ChangeThemeDialogDestination)
    }

}