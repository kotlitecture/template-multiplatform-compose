package kotli.app.feature.showcases.userflow.component.filepicker

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs
import shared.presentation.navigation.NavigationStrategy

object FilePickerShowcaseDestination : NavigationDestinationNoArgs() {

    override val id: String = "file_picker_showcase_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) =
        composable(builder) { FilePickerShowcaseScreen() }

}