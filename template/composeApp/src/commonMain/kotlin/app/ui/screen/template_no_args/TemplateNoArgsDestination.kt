package app.ui.screen.template_no_args

import androidx.navigation.NavGraphBuilder
import core.ui.navigation.ArgsStrategy
import core.ui.navigation.NavigationDestination
import core.ui.navigation.NavigationStrategy

object TemplateNoArgsDestination : NavigationDestination<Unit>() {

    override val id: String = "template_no_args_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override val argsStrategy: ArgsStrategy<Unit> = ArgsStrategy.noArgs()
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { TemplateNoArgsScreen() }

}