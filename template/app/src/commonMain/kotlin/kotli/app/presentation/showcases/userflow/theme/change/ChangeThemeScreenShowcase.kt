package kotli.app.presentation.showcases.userflow.theme.change

import kotli.app.presentation.showcases.ShowcaseItem
import kotli.app.presentation.showcases.ShowcasesViewModel
import kotli.app.theme.change.presentation.ChangeThemeDestination

/**
 * Showcase item representing a change theme screen.
 * This showcase item demonstrates the functionality of changing the theme via a dedicated screen.
 */
object ChangeThemeScreenShowcase : ShowcaseItem {

    override val label: String = "Change Theme Screen"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(ChangeThemeDestination)
    }

}