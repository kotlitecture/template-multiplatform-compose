package app.userflow.navigation.left

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import app.appViewModel
import shared.design.component.basic.AnyIcon
import app.userflow.navigation.NavigationBarViewModel
import shared.core.state.StoreObject

/**
 * Composable function to display a modal left navigation.
 *
 * @param content The content to display.
 */
@Composable
fun ModalLeftNavigation(content: @Composable () -> Unit) {
    val viewModel: NavigationBarViewModel = appViewModel(NavigationBarViewModel::class)
    val pages = viewModel.pagesStore.asStateValue()
    if (pages.isNullOrEmpty()) {
        content()
        return
    }
    if (viewModel.restrictionStore.asStateValueNotNull()) {
        content()
        return
    }
    val visibilityStore = viewModel.visibilityStore
    val drawerState: DrawerState = rememberDrawerState(getDrawerValue(visibilityStore)) {
        visibilityStore.set(it == DrawerValue.Open)
        true
    }
    DrawerVisibilityHandler(visibilityStore, drawerState)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
            ) {
                val selectedPage = viewModel.selectedPageStore.asStateValue()
                pages.forEach { page ->
                    val selected = page.id == selectedPage?.id
                    NavigationDrawerItem(
                        label = { page.getLabel()?.let { Text(text = it) } },
                        icon = { AnyIcon(model = page.getIcon(selected)) },
                        selected = selected,
                        onClick = {
                            page.onClick()
                            visibilityStore.set(false)
                        },
                    )
                }
            }
        },
        content = content
    )
}

@Stable
private fun getDrawerValue(visibilityStore: StoreObject<Boolean>): DrawerValue {
    return if (visibilityStore.get() == true) DrawerValue.Open else DrawerValue.Closed
}

@Composable
private fun DrawerVisibilityHandler(
    visibilityStore: StoreObject<Boolean>,
    drawerState: DrawerState
) {
    val visible = visibilityStore.asStateValue() == true
    LaunchedEffect(visible) {
        if (!drawerState.isAnimationRunning) {
            when {
                visible -> drawerState.open()
                else -> drawerState.close()
            }
        }
    }
}