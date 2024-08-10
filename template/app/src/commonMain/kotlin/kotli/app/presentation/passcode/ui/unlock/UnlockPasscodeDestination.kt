package kotli.app.presentation.passcode.ui.unlock

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs

object UnlockPasscodeDestination : NavigationDestinationNoArgs() {

    override val id: String = "unlock_passcode_screen"
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { UnlockPasscodeScreen() }

}