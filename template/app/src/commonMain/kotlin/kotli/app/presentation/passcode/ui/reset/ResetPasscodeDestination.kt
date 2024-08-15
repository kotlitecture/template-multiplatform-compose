package kotli.app.presentation.passcode.ui.reset

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs

object ResetPasscodeDestination : NavigationDestinationNoArgs() {

    override val id: String = "reset_passcode_screen"
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { ResetPasscodeScreen() }

}