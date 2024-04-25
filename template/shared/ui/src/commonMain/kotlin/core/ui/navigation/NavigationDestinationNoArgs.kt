package core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder

/**
 * An abstract class representing a navigation destination that doesn't require any arguments.
 * Extends [NavigationDestination] with the argument type of [Unit].
 */
abstract class NavigationDestinationNoArgs : NavigationDestination<Unit>() {

    /**
     * Provides the argument strategy for this destination, which doesn't require any arguments.
     * Returns an instance of [ArgsStrategy] with no arguments.
     */
    final override val argsStrategy: ArgsStrategy<Unit> = ArgsStrategy.noArgs()

    override fun composable(
        builder: NavGraphBuilder,
        content: @Composable (data: Unit?) -> Unit
    ) {
        super.composable(builder, content)
    }

    override fun dialog(
        builder: NavGraphBuilder,
        dismissOnBackPress: Boolean,
        dismissOnClickOutside: Boolean,
        content: @Composable (data: Unit?) -> Unit
    ) {
        super.dialog(builder, dismissOnBackPress, dismissOnClickOutside, content)
    }

}