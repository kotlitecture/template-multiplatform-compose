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
import shared.presentation.store.DataState
import shared.design.component.AppIcon
import shared.design.component.AppSpacer8
import shared.design.component.AppText
import shared.design.icon.AppIconModel

/**
 * Represents a navigation item.
 *
 * @param id The unique id associated with the item.
 * @param enabled Indicates whether the item is enabled or disabled. Default is true.
 * @param alwaysShowLabel Indicates whether to always show the label, regardless of its presence. Default is true if label is not null.
 * @param getLabel The label of the item.
 * @param getActiveIcon The icon of the item.
 * @param getInactiveIcon The icon of the item in inactive state.
 * @param onClick The callback to be invoked when the item is clicked.
 */
data class AppNavigationItem(
    val id: String,
    val enabled: Boolean = true,
    val alwaysShowLabel: Boolean = true,
    val getLabel: @Composable () -> String?,
    val getActiveIcon: () -> AppIconModel,
    val getInactiveIcon: () -> AppIconModel,
    val onClick: () -> Unit
) {
    @Stable
    fun getIcon(selected: Boolean): AppIconModel {
        return if (selected) {
            getActiveIcon()
        } else {
            getInactiveIcon()
        }
    }
}

@Composable
fun AppBottomNavigation(
    modifier: Modifier = Modifier,
    itemsStore: DataState<List<AppNavigationItem>>,
    selectionStore: DataState<AppNavigationItem>,
    visibilityStore: DataState<Boolean>
) {
    if (visibilityStore.asStateValue() == false) return
    val items = itemsStore.asStateValue()?.takeIf { it.isNotEmpty() } ?: return
    NavigationBar(modifier) {
        val selected = selectionStore.asStateValue()
        items.forEach { item ->
            val isSelected = item.id == selected?.id
            NavigationBarItem(
                label = {
                    AppText(
                        textAlign = TextAlign.Center,
                        text = item.getLabel()
                    )
                },
                icon = { AppIcon(model = item.getIcon(isSelected)) },
                alwaysShowLabel = item.alwaysShowLabel,
                onClick = item.onClick,
                selected = isSelected
            )
        }
    }
}

@Composable
fun AppDismissibleNavigation(
    modifier: Modifier = Modifier,
    itemsStore: DataState<List<AppNavigationItem>>,
    selectionStore: DataState<AppNavigationItem>,
    visibilityStore: DataState<Boolean>,
    content: @Composable () -> Unit
) {
    val items = itemsStore.asStateValue()?.takeIf { it.isNotEmpty() } ?: return run { content() }
    DismissibleNavigationDrawer(
        modifier = modifier,
        drawerState = createDrawerState(visibilityStore),
        drawerContent = {
            DismissibleDrawerSheet(
                modifier = Modifier
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
            ) {
                AppSpacer8()
                val selected = selectionStore.asStateValue()
                items.forEach { item ->
                    val isSelected = item.id == selected?.id
                    NavigationDrawerItem(
                        label = { AppText(text = item.getLabel()) },
                        icon = { AppIcon(model = item.getIcon(isSelected)) },
                        selected = isSelected,
                        onClick = {
                            item.onClick()
                            visibilityStore.set(false)
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
    modifier: Modifier = Modifier,
    itemsStore: DataState<List<AppNavigationItem>>,
    selectionStore: DataState<AppNavigationItem>,
    visibilityStore: DataState<Boolean>,
    content: @Composable () -> Unit
) {
    val items = itemsStore.asStateValue()?.takeIf { it.isNotEmpty() } ?: return run { content() }
    ModalNavigationDrawer(
        modifier = modifier,
        drawerState = createDrawerState(visibilityStore),
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
            ) {
                AppSpacer8()
                val selected = selectionStore.asStateValue()
                items.forEach { item ->
                    val isSelected = item.id == selected?.id
                    NavigationDrawerItem(
                        label = { AppText(text = item.getLabel()) },
                        icon = { AppIcon(model = item.getIcon(isSelected)) },
                        selected = isSelected,
                        onClick = {
                            item.onClick()
                            visibilityStore.set(false)
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
    modifier: Modifier = Modifier,
    itemsStore: DataState<List<AppNavigationItem>>,
    selectionStore: DataState<AppNavigationItem>,
    visibilityStore: DataState<Boolean>,
    content: @Composable () -> Unit
) {
    if (visibilityStore.asStateValue() == false) return run { content() }
    val items = itemsStore.asStateValue()?.takeIf { it.isNotEmpty() } ?: return run { content() }
    PermanentNavigationDrawer(
        modifier = modifier,
        drawerContent = {
            PermanentDrawerSheet(
                modifier = Modifier
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
            ) {
                AppSpacer8()
                val selected = selectionStore.asStateValue()
                items.forEach { item ->
                    val isSelected = item.id == selected?.id
                    NavigationDrawerItem(
                        label = { AppText(text = item.getLabel()) },
                        icon = { AppIcon(model = item.getIcon(isSelected)) },
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
    modifier: Modifier = Modifier,
    itemsStore: DataState<List<AppNavigationItem>>,
    selectionStore: DataState<AppNavigationItem>,
    visibilityStore: DataState<Boolean>,
    content: @Composable () -> Unit
) {
    if (visibilityStore.asStateValue() == false) return run { content() }
    val items = itemsStore.asStateValue()?.takeIf { it.isNotEmpty() } ?: return run { content() }
    Row(modifier = modifier) {
        NavigationRail(
            modifier = Modifier
                .fillMaxHeight()
                .verticalScroll(rememberScrollState()),
            content = {
                AppSpacer8()
                val selected = selectionStore.asStateValue()
                items.forEach { item ->
                    val isSelected = item.id == selected?.id
                    NavigationRailItem(
                        label = { AppText(text = item.getLabel()) },
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
private fun createDrawerState(visibilityStore: DataState<Boolean>): DrawerState {
    val initialValue = remember(visibilityStore) {
        if (visibilityStore.get() == true) {
            DrawerValue.Open
        } else {
            DrawerValue.Closed
        }
    }
    val drawerState: DrawerState = rememberDrawerState(initialValue) {
        visibilityStore.set(it == DrawerValue.Open)
        true
    }
    DrawerVisibilityHandler(visibilityStore, drawerState)
    return drawerState
}

@Composable
private fun DrawerVisibilityHandler(
    visibilityStore: DataState<Boolean>,
    drawerState: DrawerState
) {
    val visible = visibilityStore.asStateValue()
    LaunchedEffect(visible) {
        if (!drawerState.isAnimationRunning) {
            when {
                visible == true -> drawerState.open()
                else -> drawerState.close()
            }
        }
    }
}