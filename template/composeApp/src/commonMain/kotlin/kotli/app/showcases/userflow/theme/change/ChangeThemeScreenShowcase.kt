package kotli.app.showcases.userflow.theme.change

import kotli.app.showcases.ShowcaseItem
import kotli.app.showcases.ShowcasesViewModel
import kotli.app.userflow.theme.change.ChangeThemeDestination

/**
 * Showcase item representing a change theme screen.
 * This showcase item demonstrates the functionality of changing the theme via a dedicated screen.
 */
object ChangeThemeScreenShowcase : ShowcaseItem {

    override val label: String = "Change Theme Screen"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationState.onNext(ChangeThemeDestination)
    }

}