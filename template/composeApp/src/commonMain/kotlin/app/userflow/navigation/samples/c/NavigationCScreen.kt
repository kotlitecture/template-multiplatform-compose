package app.userflow.navigation.samples.c

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import shared.core.provideViewModel
import shared.design.component.AppText

@Composable
fun NavigationCScreen() {
    val viewModel: NavigationCViewModel = provideViewModel()
    Box(Modifier.fillMaxSize()) {
        AppText(
            modifier = Modifier.align(Alignment.Center),
            text = "C"
        )
    }
}