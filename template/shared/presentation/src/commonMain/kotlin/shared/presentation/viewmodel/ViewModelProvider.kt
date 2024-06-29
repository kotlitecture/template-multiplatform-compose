package shared.presentation.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.lifecycle.ViewModelProvider

val LocalViewModelFactory = compositionLocalOf { ViewModelFactory }

@Stable
@Composable
fun ViewModelProvider(factory: ViewModelProvider.Factory, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalViewModelFactory provides factory) {
        content()
    }
}