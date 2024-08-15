package kotli.app.presentation.showcases.userflow.component.image.coil

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs

object CoilShowcaseDestination : NavigationDestinationNoArgs() {

    override val id: String = "coil_showcase_screen"
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { CoilShowcaseScreen() }

}