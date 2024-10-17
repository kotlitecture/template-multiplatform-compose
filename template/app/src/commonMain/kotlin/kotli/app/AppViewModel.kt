package kotli.app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot
import androidx.navigation.NavHostController
import kotli.app.common.presentation.navigation.NavigationItem
import kotli.app.common.presentation.navigation.NavigationMutableState
import kotli.app.common.presentation.navigation.NavigationState
import kotli.app.presentation.showcases.Showcases
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.mapNotNull
import shared.design.component.AppSnackbarState
import shared.design.icon.AppIconModel
import shared.design.icon.AppIcons
import shared.presentation.misc.ifIndex
import shared.presentation.viewmodel.BaseViewModel

class AppViewModel(snackbarState: AppSnackbarState) : BaseViewModel() {

    private val navigationState = NavigationMutableState()
    private val _state = AppMutableState(snackbarState, navigationState)
    val state: AppState = _state

    fun onBind(navController: NavHostController) = async("Init app navigation") {
        val startDestination = getStartDestination()
        val items = createItems(navController::singleInstance)
        val itemsById = items.associateBy { item -> item.id }

        configure(
            items = items,
            startDestination = startDestination,
            selected = itemsById[startDestination.getNavigationId()],
        )

        navController.currentBackStackEntryFlow
            .mapNotNull { entry -> entry.destination.route }
            .distinctUntilChanged()
            .mapNotNull { route ->
                val index = route.indexOf('/').ifIndex() ?: route.length
                route.subSequence(0, index)
            }
            .collectLatest { routeClassName ->
                configure(
                    items = items,
                    startDestination = startDestination,
                    selected = itemsById[routeClassName],
                )
            }
    }

    private fun getStartDestination(): Any {
        return Showcases
    }

    private fun Any.getNavigationId(): String = this::class.qualifiedName.orEmpty()

    private fun configure(
        startDestination: Any,
        selected: NavigationItem?,
        items: List<NavigationItem>
    ) {
        Snapshot.withMutableSnapshot {
            _state.startDestination = startDestination
            navigationState.selected = selected
            navigationState.visible = true
            navigationState.items = items
        }
    }

    private fun createItems(onRoute: (route: Any) -> Unit) = listOf(
        // start {showcases}
        createItem(
            route = Showcases,
            onRoute = onRoute,
            label = "Showcases",
            activeIcon = AppIcons.school,
            inactiveIcon = AppIcons.school,
        ),
        // end {showcases}
        createItem(
            route = Showcases,
            onRoute = onRoute,
            label = "Page 1",
            activeIcon = AppIcons.wineBar,
            inactiveIcon = AppIcons.wineBar,
        ),
        createItem(
            route = Showcases,
            onRoute = onRoute,
            label = "Page 2",
            activeIcon = AppIcons.localDrink,
            inactiveIcon = AppIcons.localDrink,
        ),
        createItem(
            route = Showcases,
            onRoute = onRoute,
            label = "Page 3",
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
            id = route.getNavigationId()
        )
    }

    class AppMutableState(
        override val snackbarState: AppSnackbarState,
        override val navigationState: NavigationState
    ) : AppState {
        override var startDestination: Any? by mutableStateOf(null)
    }
}