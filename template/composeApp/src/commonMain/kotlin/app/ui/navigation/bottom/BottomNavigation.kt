package app.ui.navigation.bottom

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import app.appViewModel
import app.ui.component.basic.AnyIcon
import app.ui.navigation.NavigationBarViewModel
import core.ui.state.StoreObject

/**
 * Composable function responsible for rendering the bottom navigation bar.
 */
@Composable
fun BottomNavigation() {
    val viewModel: NavigationBarViewModel = appViewModel(NavigationBarViewModel::class)
    val pages = viewModel.pagesStore.asStateValue()?.takeIf { it.isNotEmpty() } ?: return
    if (viewModel.restrictionStore.asStateValueNotNull()) return
    val visibilityStore = viewModel.visibilityStore
    val visibilityState = remember { MutableTransitionState(visibilityStore.get() != false) }
    val animation = remember { tween<IntOffset>(150, easing = LinearEasing) }
    val offset: (fullHeight: Int) -> Int = remember { { it / 2 } }
    VisibilityHandler(visibilityStore, visibilityState)
    AnimatedVisibility(
        visibleState = visibilityState,
        enter = slideInVertically(animation, offset),
        exit = slideOutVertically(animation, offset)
    ) {
        NavigationBar {
            val selectedPage = viewModel.selectedPageStore.asStateValue()
            pages.forEach { page ->
                val selected = page.id == selectedPage?.id
                NavigationBarItem(
                    label = {
                        page.getLabel()?.let {
                            Text(
                                text = it,
                                textAlign = TextAlign.Center
                            )
                        }
                    },
                    icon = { AnyIcon(model = page.getIcon(selected)) },
                    alwaysShowLabel = page.alwaysShowLabel,
                    onClick = page.onClick,
                    selected = selected
                )
            }
        }
    }
}

@Composable
private fun VisibilityHandler(
    visibilityStore: StoreObject<Boolean>,
    visibleState: MutableTransitionState<Boolean>
) {
    val visible = visibilityStore.asStateValue() != false
    LaunchedEffect(visible) { visibleState.targetState = visible }
}