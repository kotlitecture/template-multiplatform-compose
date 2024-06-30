package kotli.app.presentation.template.screen_without_args

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs
import shared.presentation.navigation.NavigationStrategy

object TemplateNoArgsDestination : NavigationDestinationNoArgs() {

    override val id: String = "template_no_args_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { TemplateNoArgsScreen() }

}