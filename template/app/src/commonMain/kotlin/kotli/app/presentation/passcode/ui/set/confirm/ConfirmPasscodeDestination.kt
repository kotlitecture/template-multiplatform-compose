package kotli.app.presentation.passcode.ui.set.confirm

import androidx.navigation.NavGraphBuilder
import kotlinx.serialization.Serializable
import shared.presentation.navigation.ArgsStrategy
import shared.presentation.navigation.NavigationDestination

object ConfirmPasscodeDestination : NavigationDestination<ConfirmPasscodeDestination.Data>() {

    override val id: String = "confirm_passcode_screen"
    override val argsStrategy: ArgsStrategy<Data> = ArgsStrategy.json(Data.serializer())
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { data ->
        ConfirmPasscodeScreen(data!!)
    }

    @Serializable
    data class Data(
        val code: String
    )

}