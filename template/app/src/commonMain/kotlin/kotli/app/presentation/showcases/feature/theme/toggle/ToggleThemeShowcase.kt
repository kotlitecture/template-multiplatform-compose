package kotli.app.presentation.showcases.feature.theme.toggle

import androidx.compose.foundation.layout.sizeIn
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import kotli.app.presentation.showcases.ShowcaseItem
import kotli.app.presentation.showcases.ShowcasesViewModel
import kotli.app.presentation.theme.toggle.ToggleThemeButton
import shared.presentation.navigation.NavigationDestination
import shared.presentation.navigation.NavigationDestinationNoArgs
import shared.presentation.navigation.NavigationStrategy
import shared.design.component.AppDialogContent

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

private object ToggleThemeDestination : NavigationDestinationNoArgs() {
    override val id: String = "toggle_theme_dialog"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = dialog(builder) {
        AppDialogContent(
            modifier = Modifier
                .sizeIn(
                    minWidth = 100.dp,
                    minHeight = 100.dp
                )
        ) {
            ToggleThemeButton()
        }
    }
}