package kotli.app.presentation.passcode.ui.set.enter

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs

object EnterPasscodeDestination : NavigationDestinationNoArgs() {

    override val id: String = "enter_passcode_screen"
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { EnterPasscodeScreen() }

}