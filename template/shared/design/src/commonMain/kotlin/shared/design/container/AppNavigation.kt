package shared.design.container

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DismissibleDrawerSheet
import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import shared.design.component.AppIcon
import shared.design.component.AppSpacer8
import shared.design.component.AppText
import shared.design.icon.AppIconModel

data class AppNavigationItem(
    val id: Int,
    val label: String?,
    val enabled: Boolean,
    val showLabel: Boolean,
    val activeIcon: AppIconModel,
    val inactiveIcon: AppIconModel,
    val onClick: () -> Unit
) {
    @Stable
    fun getIcon(selected: Boolean): AppIconModel = if (selected) activeIcon else inactiveIcon
}

@Stable
interface AppNavigationState {
    val items: List<AppNavigationItem>
    val selected: AppNavigationItem?
    var visible: Boolean?
}

@Composable
fun AppBottomNavigation(
    state: AppNavigationState,
    modifier: Modifier = Modifier,
) {
    if (state.visible == false) return
    val items = state.items.takeIf { items -> items.isNotEmpty() } ?: return

    NavigationBar(modifier) {
        val selected = state.selected
        items.forEach { item ->
            val isSelected = item.id == selected?.id
            NavigationBarItem(
                label = {
                    AppText(
                        textAlign = TextAlign.Center,
                        text = item.label
                    )
                },
                icon = { AppIcon(model = item.getIcon(isSelected)) },
                alwaysShowLabel = item.showLabel,
                onClick = item.onClick,
                selected = isSelected
            )
        }
    }
}

@Composable
fun AppDismissibleNavigation(
    state: AppNavigationState,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val items = state.items.takeIf { items -> items.isNotEmpty() } ?: return run { content() }

    DismissibleNavigationDrawer(
        modifier = modifier,
        drawerState = createDrawerState(state),
        drawerContent = {
            DismissibleDrawerSheet(
                modifier = Modifier
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
            ) {
                AppSpacer8()
                val selected = state.selected
                items.forEach { item ->
                    val isSelected = item.id == selected?.id
                    NavigationDrawerItem(
                        label = { AppText(text = item.label) },
                        icon = { AppIcon(model = item.getIcon(isSelected)) },
                        selected = isSelected,
                        onClick = {
                            item.onClick()
                            state.visible = false
                        }
                    )
                }
                AppSpacer8()
            }
        },
        content = content
    )
}

@Composable
fun AppModalNavigation(
    state: AppNavigationState,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val items = state.items.takeIf { items -> items.isNotEmpty() } ?: return run { content() }

    ModalNavigationDrawer(
        modifier = modifier,
        drawerState = createDrawerState(state),
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
            ) {
                AppSpacer8()
                val selected = state.selected
                items.forEach { item ->
                    val isSelected = item.id == selected?.id
                    NavigationDrawerItem(
                        label = { AppText(text = item.label) },
                        icon = { AppIcon(model = item.getIcon(isSelected)) },
                        selected = isSelected,
                        onClick = {
                            item.onClick()
                            state.visible = false
                        }
                    )
                }
                AppSpacer8()
            }
        },
        content = content
    )
}

@Composable
fun AppPermanentNavigation(
    state: AppNavigationState,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    if (state.visible == false) return run { content() }
    val items = state.items.takeIf { items -> items.isNotEmpty() } ?: return run { content() }

    PermanentNavigationDrawer(
        modifier = modifier,
        drawerContent = {
            PermanentDrawerSheet(
                modifier = Modifier
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
            ) {
                AppSpacer8()
                val selected = state.selected
                items.forEach { item ->
                    val isSelected = item.id == selected?.id
                    NavigationDrawerItem(
                        label = { AppText(text = item.label) },
                        icon = { AppIcon(model = item.getIcon(isSelected), size = 24.dp) },
                        selected = isSelected,
                        onClick = item.onClick
                    )
                }
                AppSpacer8()
            }
        },
        content = content
    )
}

@Composable
fun AppRailNavigation(
    state: AppNavigationState,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    if (state.visible == false) return run { content() }
    val items = state.items.takeIf { items -> items.isNotEmpty() } ?: return run { content() }

    Row(modifier = modifier) {
        NavigationRail(
            modifier = Modifier
                .fillMaxHeight()
                .verticalScroll(rememberScrollState()),
            content = {
                AppSpacer8()
                val selected = state.selected
                items.forEach { item ->
                    val isSelected = item.id == selected?.id
                    NavigationRailItem(
                        label = { AppText(text = item.label) },
                        icon = { AppIcon(model = item.getIcon(isSelected)) },
                        onClick = item.onClick,
                        selected = isSelected,
                    )
                }
                AppSpacer8()
            }
        )
        content()
    }
}

@Composable
private fun createDrawerState(state: AppNavigationState): DrawerState {
    val initial =
        remember(state) { if (state.visible == true) DrawerValue.Open else DrawerValue.Closed }
    val drawerState: DrawerState = rememberDrawerState(initial) { drawerValue ->
        state.visible = drawerValue == DrawerValue.Open
        true
    }
    DrawerVisibilityHandler(state, drawerState)
    return drawerState
}

@Composable
private fun DrawerVisibilityHandler(
    state: AppNavigationState,
    drawerState: DrawerState
) {
    val visible = state.visible
    LaunchedEffect(visible) {
        if (!drawerState.isAnimationRunning) {
            when {
                visible == true -> drawerState.open()
                else -> drawerState.close()
            }
        }
    }
}