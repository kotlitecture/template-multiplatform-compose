package app.ui.screen.template

import androidx.navigation.NavGraphBuilder
import core.ui.navigation.ArgsStrategy
import core.ui.navigation.NavigationDestination
import core.ui.navigation.NavigationStrategy
import kotlinx.serialization.Serializable

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