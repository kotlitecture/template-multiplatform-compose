package kotli.app.feature.navigation.provide.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.serialization.generateHashCode
import kotli.app.common.presentation.navigation.NavigationItem
import kotli.app.common.presentation.navigation.NavigationState
import kotli.app.feature.navigation.a.presentation.ARoute
import kotli.app.feature.navigation.b.presentation.BRoute
import kotli.app.feature.navigation.c.presentation.CRoute
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

class NavigationViewModel : BaseViewModel() {

    private val _state = NavigationMutableState()
    val state: NavigationState = _state

    fun onBind(navController: NavHostController) = async("Init navigation") {
        val items = createItems(navController::singleInstance)
        val itemsById = items.associateBy { item -> item.id }

        navController.currentBackStackEntryFlow
            .mapNotNull { entry -> entry.destination.id }
            .distinctUntilChanged()
            .collectLatest { destinationId ->
                withMutableSnapshot {
                    _state.selected = itemsById[destinationId]
                    _state.visible = true
                    _state.items = items
                }
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

    private class NavigationMutableState : NavigationState {
        override var items: List<NavigationItem> by mutableStateOf(emptyList())
        override var selected: NavigationItem? by mutableStateOf(null)
        override var visible: Boolean? by mutableStateOf(null)
    }
}