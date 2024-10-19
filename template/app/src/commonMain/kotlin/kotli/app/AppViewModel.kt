package kotli.app

import androidx.navigation.NavHostController
import androidx.navigation.serialization.generateHashCode
import kotli.app.common.presentation.navigation.NavigationItem
import kotli.app.feature.a.presentation.ARoute
import kotli.app.feature.b.presentation.BRoute
import kotli.app.feature.c.presentation.CRoute
import kotli.app.feature.showcases.ShowcasesRoute
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.serializer
import shared.design.icon.AppIconModel
import shared.design.icon.AppIcons
import shared.presentation.misc.singleInstance
import shared.presentation.viewmodel.BaseViewModel

class AppViewModel(
    private val _state: AppMutableState
) : BaseViewModel() {

    val state: AppState = _state

    fun onBind(navController: NavHostController) = async("Init app navigation") {
        val items = createItems(navController::singleInstance)
        val itemsById = items.associateBy { item -> item.id }
        val startDestination = getStartDestination()

        configure(
            items = items,
            startDestination = startDestination,
            selected = itemsById[startDestination.createItemId()],
        )

        navController.currentBackStackEntryFlow
            .mapNotNull { entry -> entry.destination.id }
            .distinctUntilChanged()
            .collectLatest { destinationId ->
                configure(
                    items = items,
                    startDestination = startDestination,
                    selected = itemsById[destinationId],
                )
            }
    }

    private fun getStartDestination(): Any {
        return ShowcasesRoute
    }

    private fun configure(
        startDestination: Any,
        selected: NavigationItem?,
        items: List<NavigationItem>
    ) {
        withMutableSnapshot {
            _state.startDestination = startDestination
            _state.navigationState.selected = selected
            _state.navigationState.visible = true
            _state.navigationState.items = items
        }
    }

    private fun createItems(onRoute: (route: Any) -> Unit) = listOf(
        // start {showcases}
        createItem(
            route = ShowcasesRoute,
            onRoute = onRoute,
            label = "Showcases",
            activeIcon = AppIcons.school,
            inactiveIcon = AppIcons.school,
        ),
        // end {showcases}
        createItem(
            route = ARoute,
            onRoute = onRoute,
            label = "Page A",
            activeIcon = AppIcons.wineBar,
            inactiveIcon = AppIcons.wineBar,
        ),
        createItem(
            route = BRoute,
            onRoute = onRoute,
            label = "Page B",
            activeIcon = AppIcons.localDrink,
            inactiveIcon = AppIcons.localDrink,
        ),
        createItem(
            route = CRoute,
            onRoute = onRoute,
            label = "Page C",
            activeIcon = AppIcons.coffee,
            inactiveIcon = AppIcons.coffee,
        )
    )

    private fun createItem(
        onRoute: (route: Any) -> Unit,
        inactiveIcon: AppIconModel,
        activeIcon: AppIconModel,
        label: String?,
        route: Any,
    ): NavigationItem {
        return NavigationItem(
            label = label,
            enabled = true,
            showLabel = false,
            activeIcon = activeIcon,
            inactiveIcon = inactiveIcon,
            onClick = { onRoute(route) },
            id = route.createItemId()
        )
    }

    @OptIn(InternalSerializationApi::class)
    private fun Any.createItemId(): Int = this::class.serializer().generateHashCode()

}