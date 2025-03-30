package shared.presentation.ui.container

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import shared.presentation.ui.component.AppSnackbarState

@Composable
fun AppScaffold(
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    snackbarState: AppSnackbarState = remember { AppSnackbarState() },
    content: @Composable (PaddingValues) -> Unit = {},
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = topBar,
        content = content,
        bottomBar = bottomBar,
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = FabPosition.End,
        snackbarHost = { SnackbarHost(snackbarState.hostState) },
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets.exclude(ScaffoldDefaults.contentWindowInsets),
    )
}