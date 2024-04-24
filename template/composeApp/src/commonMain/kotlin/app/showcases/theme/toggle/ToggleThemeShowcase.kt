package app.showcases.theme.toggle

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import app.showcases.ShowcaseItem
import app.showcases.ShowcasesViewModel
import app.userflow.theme.toggle.ToggleThemeButton
import core.ui.navigation.ArgsStrategy
import core.ui.navigation.NavigationDestination
import core.ui.navigation.NavigationStrategy
import core.ui.theme.ThemeData

/**
 * Showcase item representing a toggle theme button.
 * This button allows toggling between different themes.
 */
object ToggleThemeShowcase : ShowcaseItem {

    override val label: String = "Toggle Theme Button"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationState.onNext(ToggleThemeDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        ToggleThemeDestination
    )

}

private object ToggleThemeDestination : NavigationDestination<Unit>() {
    override val id: String = "toggle_theme_dialog"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override val argsStrategy: ArgsStrategy<Unit> = ArgsStrategy.noArgs()
    override fun doBind(builder: NavGraphBuilder) = dialog(builder) {
        Box(
            modifier = Modifier
                .sizeIn(minWidth = 100.dp, minHeight = 100.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(ThemeData.current.primary)
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            ToggleThemeButton()
        }
    }

}