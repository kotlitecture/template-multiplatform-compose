package kotli.app.presentation.template.screen_with_args

import androidx.navigation.NavGraphBuilder
import kotlinx.serialization.Serializable
import shared.presentation.navigation.ArgsStrategy
import shared.presentation.navigation.NavigationDestination
import shared.presentation.navigation.NavigationStrategy

object TemplateDestination : NavigationDestination<TemplateDestination.Data>() {

    override val id: String = "template_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override val argsStrategy: ArgsStrategy<Data> = ArgsStrategy.json(Data.serializer())
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { data ->
        TemplateScreen(data!!)
    }

    @Serializable
    data class Data(
        val title: String
    )

}