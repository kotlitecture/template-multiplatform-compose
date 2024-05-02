package kotli.app.ui.screen.template

import androidx.navigation.NavGraphBuilder
import kotlinx.serialization.Serializable
import shared.core.navigation.ArgsStrategy
import shared.core.navigation.NavigationDestination
import shared.core.navigation.NavigationStrategy

object TemplateDestination : NavigationDestination<TemplateDestination.Data>() {

    override val id: String = "template_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override val argsStrategy: ArgsStrategy<Data> = ArgsStrategy.json(Data.serializer())
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { TemplateScreen(it!!) }

    @Serializable
    data class Data(
        val title: String
    )

}