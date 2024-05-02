package shared.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModelProvider

@Stable
@Composable
fun ViewModelProvider(factory: ViewModelProvider.Factory, content: @Composable () -> Unit) {
    BaseViewModel.factory = factory
    content()
}