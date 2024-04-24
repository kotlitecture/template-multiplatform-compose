package app.showcases

import androidx.navigation.NavGraphBuilder
import core.ui.navigation.ArgsStrategy
import core.ui.navigation.NavigationDestination
import core.ui.navigation.NavigationStrategy

/**
 * Navigation destination representing the flow for showcasing various features.
 */
object ShowcasesDestination : NavigationDestination<Unit>() {

    override val id: String = "showcases_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.SingleInstance
    override val argsStrategy: ArgsStrategy<Unit> = ArgsStrategy.noArgs()
    override fun doBind(builder: NavGraphBuilder) {
        composable(builder) { ShowcasesScreen() }
        Showcases.all
            .filterIsInstance<ShowcaseItem>()
            .map { it.dependsOn() }
            .flatten()
            .onEach { it.bind(builder) }
    }

}