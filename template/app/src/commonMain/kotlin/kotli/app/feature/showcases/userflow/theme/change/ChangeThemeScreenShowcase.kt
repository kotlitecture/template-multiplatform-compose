package kotli.app.feature.showcases.userflow.theme.change

import kotli.app.feature.showcases.ShowcaseItem
import kotli.app.feature.showcases.ShowcasesViewModel
import kotli.app.feature.theme.change.presentation.ChangeThemeDestination

/**
 * Showcase item representing a change theme screen.
 * This showcase item demonstrates the functionality of changing the theme via a dedicated screen.
 */
object ChangeThemeScreenShowcase : kotli.app.feature.showcases.ShowcaseItem {

    override val label: String = "Change Theme Screen"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(ChangeThemeDestination)
    }

}