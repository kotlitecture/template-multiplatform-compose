package app.ui.navigation.bottom

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import app.appViewModel
import shared.design.component.basic.AnyIcon
import app.ui.navigation.NavigationBarViewModel

/**
 * Composable function responsible for rendering the bottom navigation bar.
 */
@Composable
fun BottomNavigation(modifier: Modifier = Modifier) {
    val viewModel: NavigationBarViewModel = appViewModel(NavigationBarViewModel::class)
    val pages = viewModel.pagesStore.asStateValue()
    if (pages.isNullOrEmpty()) {
        return
    }
    if (viewModel.restrictionStore.asStateValueNotNull()) {
        return
    }
    if (viewModel.visibilityStore.get() == false) {
        return
    }
    NavigationBar(modifier) {
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