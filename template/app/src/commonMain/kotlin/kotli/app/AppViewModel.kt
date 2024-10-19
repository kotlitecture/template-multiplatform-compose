package kotli.app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot
import androidx.navigation.NavHostController
import androidx.navigation.serialization.generateHashCode
import kotli.app.common.presentation.navigation.NavigationItem
import kotli.app.common.presentation.navigation.NavigationMutableState
import kotli.app.common.presentation.navigation.NavigationState
import kotli.app.feature.a.presentation.ARoute
import kotli.app.feature.passcode.reset.presentation.ResetPasscodeRoute
import kotli.app.feature.passcode.set.presentation.SetPasscodeRoute
import kotli.app.feature.showcases.presentation.ShowcasesRoute
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.serializer
import shared.design.component.AppSnackbarState
import shared.design.icon.AppIconModel
import shared.design.icon.AppIcons
import shared.presentation.misc.singleInstance
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
            route = ResetPasscodeRoute,
            onRoute = onRoute,
            label = "Page B",
            activeIcon = AppIcons.localDrink,
            inactiveIcon = AppIcons.localDrink,
        ),
        createItem(
            route = SetPasscodeRoute,
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

    private class AppMutableState(
        override val snackbarState: AppSnackbarState,
        override val navigationState: NavigationState,
        override val transitionDuration: Int = 100
    ) : AppState {
        override var startDestination: Any? by mutableStateOf(null)
    }
}