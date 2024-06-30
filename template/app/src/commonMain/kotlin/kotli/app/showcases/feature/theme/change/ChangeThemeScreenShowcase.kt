package kotli.app.showcases.feature.theme.change

import kotli.app.showcases.ShowcaseItem
import kotli.app.showcases.ShowcasesViewModel
import kotli.app.presentation.theme.change.ChangeThemeDestination

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