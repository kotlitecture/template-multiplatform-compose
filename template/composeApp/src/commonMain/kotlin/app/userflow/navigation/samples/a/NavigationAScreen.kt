package app.userflow.navigation.samples.a

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import shared.core.provideViewModel
import shared.design.component.AppText

@Composable
fun NavigationAScreen() {
    val viewModel: NavigationAViewModel = provideViewModel()
    Box(Modifier.fillMaxSize()) {
        AppText(
            modifier = Modifier.align(Alignment.Center),
            text = "A"
        )
    }
}