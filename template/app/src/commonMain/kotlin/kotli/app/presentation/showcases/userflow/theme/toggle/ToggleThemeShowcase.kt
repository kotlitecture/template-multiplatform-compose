package kotli.app.presentation.showcases.userflow.theme.toggle

import kotli.app.presentation.showcases.ShowcaseItem
import kotli.app.presentation.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

/**
 * Showcase item representing a toggle theme button.
 * This button allows toggling between different themes.
 */
object ToggleThemeShowcase : ShowcaseItem {

    override val label: String = "Toggle Theme Button"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(ToggleThemeDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        ToggleThemeDestination
    )

}

