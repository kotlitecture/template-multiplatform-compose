package kotli.app.feature.theme.change.presentation

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs

object ChangeThemeDestination : NavigationDestinationNoArgs() {

    override val id: String = "change_theme_screen"
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { ChangeThemeScreen() }

}