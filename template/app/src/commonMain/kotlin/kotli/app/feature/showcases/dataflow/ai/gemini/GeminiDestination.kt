package kotli.app.feature.showcases.dataflow.ai.gemini

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs
import shared.presentation.navigation.NavigationStrategy

object GeminiDestination : NavigationDestinationNoArgs() {

    override val id: String = "gemini_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { GeminiScreen() }

}