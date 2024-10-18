package kotli.app.feature.showcases.userflow.component.markdown

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs

object MarkdownShowcaseDestination : NavigationDestinationNoArgs() {

    override val id: String = "markdown_screen"
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { MarkdownShowcaseScreen() }

}