package kotli.app.feature.passcode.ui.set

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs

object SetPasscodeDestination : NavigationDestinationNoArgs() {

    override val id: String = "set_passcode_screen"
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { SetPasscodeScreen() }

}