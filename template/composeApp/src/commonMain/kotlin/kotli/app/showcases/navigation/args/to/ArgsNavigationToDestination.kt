package kotli.app.showcases.navigation.args.to

import androidx.navigation.NavGraphBuilder
import kotlinx.serialization.Serializable
import shared.core.navigation.ArgsStrategy
import shared.core.navigation.NavigationDestination
import shared.core.navigation.NavigationStrategy

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