package app.userflow.navigation.left

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import app.appViewModel
import shared.design.component.basic.AnyIcon
import app.userflow.navigation.NavigationBarViewModel

/**
 * Composable function to display rail navigation.
 *
 * @param content The content to display.
 */
@Composable
fun RailNavigation(content: @Composable () -> Unit) {
    val viewModel: NavigationBarViewModel = appViewModel()
    val pages = viewModel.pagesStore.asStateValue()
    if (pages.isNullOrEmpty()) {
        content()
        return
    }
    if (viewModel.restrictionStore.asStateValueNotNull()) {
        content()
        return
    }
    if (viewModel.visibilityStore.get() == false) {
        content()
        return
    }
    Row(
        modifier = Modifier.fillMaxSize(),
    ) {
        NavigationRail(
            modifier = Modifier
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
        ) {
            val selectedPage = viewModel.selectedPageStore.asStateValue()
            pages.forEach { page ->
                val selected = page.id == selectedPage?.id
                NavigationRailItem(
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
        content()
    }
}