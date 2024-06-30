package kotli.app.presentation.showcases.userflow.navigation.args.to

import androidx.navigation.NavGraphBuilder
import kotlinx.serialization.Serializable
import shared.presentation.navigation.ArgsStrategy
import shared.presentation.navigation.NavigationDestination
import shared.presentation.navigation.NavigationStrategy

object ArgsNavigationToDestination : NavigationDestination<ArgsNavigationToDestination.Data>() {

    override val id: String = "navigation_args_to_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override val argsStrategy: ArgsStrategy<Data> = ArgsStrategy.json(Data.serializer())
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { ArgsNavigationToScreen(it!!) }

    @Serializable
    data class Data(
        val userName: String?
    )

}