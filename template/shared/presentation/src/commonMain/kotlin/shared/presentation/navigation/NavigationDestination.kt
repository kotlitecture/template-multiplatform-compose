package shared.presentation.navigation

import androidx.collection.MutableScatterMap
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.navArgument
import shared.presentation.misc.ifIndex

/**
 * Abstract class representing a navigation destination.
 *
 * @param D The type of data associated with this destination.
 */
@Immutable
abstract class NavigationDestination<D> {

    /** Unique identifier for this destination. */
    abstract val id: String

    /** Strategy for handling arguments associated with this destination. */
    abstract val argsStrategy: ArgsStrategy<D>

    /** Strategy for navigation behavior. */
    open val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance

    /** Route string for navigation. */
    val route by lazy { "$id?$ATTR_DATA={$ATTR_DATA}" }

    /**
     * Binds this destination to the given NavGraphBuilder.
     *
     * @param builder The NavGraphBuilder to bind to.
     */
    fun bind(builder: NavGraphBuilder) {
        register(this)
        doBind(builder)
    }

    /**
     * Binds the given navigation destinations to the NavGraphBuilder.
     *
     * @param builder The NavGraphBuilder to bind the navigation destinations to.
     * @param navigation The navigation destinations to bind.
     */
    fun bind(builder: NavGraphBuilder, vararg navigation: NavigationDestination<*>) {
        navigation.forEach { it.bind(builder) }
    }

    /**
     * Navigates to this destination.
     *
     * @param data The data associated with the navigation.
     * @param strategy The navigation strategy to use.
     * @param controller The NavHostController for navigation.
     */
    @Suppress("UNCHECKED_CAST")
    internal fun navigate(data: Any?, strategy: NavigationStrategy, controller: NavHostController) {
        val uriString = createUriString(data as? D)
        strategy.proceed(route, uriString, controller)
    }

    /**
     * Performs binding of this destination to the NavGraphBuilder.
     *
     * @param builder The NavGraphBuilder to bind to.
     */
    protected abstract fun doBind(builder: NavGraphBuilder)

    /**
     * Defines a composable route for this destination.
     *
     * @param builder The NavGraphBuilder to bind to.
     * @param provider The composable content to display.
     */
    protected open fun composable(
        builder: NavGraphBuilder,
        provider: NavigationContentProvider<D>
    ) {
        builder.composable(
            route = route,
            arguments = createArgs(),
            content = { entry -> route(RouteData(entry, provider)) }
        )
    }

    /**
     * Defines a dialog route for this destination.
     *
     * @param builder The NavGraphBuilder to bind to.
     * @param dismissOnBackPress Whether the dialog dismisses on back press.
     * @param dismissOnClickOutside Whether the dialog dismisses on click outside.
     * @param provider The composable content to display.
     */
    protected open fun dialog(
        builder: NavGraphBuilder,
        dismissOnBackPress: Boolean = true,
        dismissOnClickOutside: Boolean = true,
        provider: NavigationContentProvider<D>
    ) {
        builder.dialog(
            route = route,
            arguments = createArgs(),
            dialogProperties = DialogProperties(
                usePlatformDefaultWidth = false,
                dismissOnBackPress = dismissOnBackPress,
                dismissOnClickOutside = dismissOnClickOutside
            ),
            content = { entry -> route(RouteData(entry, provider)) }
        )
    }

    @Composable
    private fun route(routeData: RouteData<D>) {
        val value = routeData.entry.arguments?.getString(ATTR_DATA)
        val data = value?.let(argsStrategy::toObject)
        routeData.provider(data)
    }

    /**
     * Converts the navigation destination data to a Uri string.
     *
     * @param data The data to be included in the Uri string.
     * @return The URI representing the navigation destination.
     */
    private fun createUriString(data: D? = null): String {
        if (data == null) return route
        return "$id?$ATTR_DATA=${argsStrategy.toString(data)}"
    }

    private fun createArgs() = listOf(
        navArgument(ATTR_DATA) {
            type = NavType.StringType
            nullable = true
        }
    )

    companion object {
        private const val ATTR_DATA = "data"
        private val DESTINATIONS = MutableScatterMap<String, NavigationDestination<*>>()

        /**
         * Retrieves a navigation destination by its unique identifier.
         *
         * @param id The unique identifier of the navigation destination.
         * @return The navigation destination, or null if not found.
         */
        fun getById(id: String): NavigationDestination<*>? = DESTINATIONS[id]

        /**
         * Retrieves a navigation destination by its route.
         *
         * @param route The route of the navigation destination
         * @return The navigation destination, or null if not found.
         */
        fun getByRoute(route: String): NavigationDestination<*>? = getById(extractId(route))

        internal fun register(destination: NavigationDestination<*>) {
            val prev = DESTINATIONS.put(destination.id, destination)
            check(prev == null || prev === destination) {
                """
                    Destination ${destination.id} is not unique or has been registered multiple times.
                    
                    Please address this issue without removing the check.
                """.trimIndent()
            }
        }

        private fun extractId(route: String): String {
            return route.indexOf('?')
                .ifIndex()
                ?.let(route::take)
                ?: route
        }
    }

    @Immutable
    data class RouteData<D>(
        val entry: NavBackStackEntry,
        val provider: NavigationContentProvider<D>
    )

}