package shared.presentation.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.lifecycle.viewmodel.viewModelFactory

val LocalViewModelFactory = compositionLocalOf { ViewModelFactory }

@Stable
@Composable
fun ViewModelProvider(factory: ViewModelProvider.Factory, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalViewModelFactory provides factory) {
        content()
    }
}

@Stable
@Composable
fun ViewModelProvider(
    builder: InitializerViewModelFactoryBuilder.() -> Unit,
    content: @Composable () -> Unit
) {
    val factory = remember { viewModelFactory(builder) }
    ViewModelProvider(factory, content)
}