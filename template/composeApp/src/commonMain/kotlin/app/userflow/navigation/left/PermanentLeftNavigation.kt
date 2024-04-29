package app.userflow.navigation.left

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import app.userflow.navigation.NavigationBarViewModel
import shared.core.provideViewModel
import shared.design.component.basic.AnyIcon

/**
 * Composable function to display permanent left navigation.
 *
 * @param content The content to display.
 */
@Composable
fun PermanentLeftNavigation(content: @Composable () -> Unit) {
    val viewModel: NavigationBarViewModel = provideViewModel()
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
    PermanentNavigationDrawer(
        drawerContent = {
            PermanentDrawerSheet(
                modifier = Modifier
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
            ) {
                val selectedPage = viewModel.selectedPageStore.asStateValue()
                pages.forEach { page ->
                    val selected = page.id == selectedPage?.id
                    NavigationDrawerItem(
                        label = {
                            page.getLabel()?.let {
                                Text(
                                    text = it,
                                    textAlign = TextAlign.Center
                                )
                            }
                        },
                        icon = { AnyIcon(model = page.getIcon(selected)) },
                        onClick = page.onClick,
                        selected = selected
                    )
                }
            }
        },
        content = content
    )
}