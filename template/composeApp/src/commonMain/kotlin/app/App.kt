package app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import app.ui.theme.AppTheme
import kotlin.reflect.KClass

@Composable
fun App() = ViewModelStoreOwnerProvider {
    AppTheme {
        AppScreen()
    }
}

@Composable
internal fun <VM : ViewModel> provideViewModel(modelClass: KClass<VM>): VM =
    viewModel(modelClass, factory = AppViewModelFactory)

private class ComposeViewModelStoreOwner : ViewModelStoreOwner {
    override val viewModelStore = ViewModelStore()
    fun dispose() = viewModelStore.clear()
}

@Composable
private fun rememberComposeViewModelStoreOwner(): ViewModelStoreOwner {
    val viewModelStoreOwner = remember { ComposeViewModelStoreOwner() }
    DisposableEffect(viewModelStoreOwner) {
        onDispose { viewModelStoreOwner.dispose() }
    }
    return viewModelStoreOwner
}

@Composable
internal fun ViewModelStoreOwnerProvider(content: @Composable () -> Unit) {
    if (LocalViewModelStoreOwner.current != null) {
        content()
    } else {
        // TODO :: expected to be fixed in Compose Multiplatform 1.7.0
        CompositionLocalProvider(
            LocalViewModelStoreOwner provides rememberComposeViewModelStoreOwner(),
            content = content
        )
    }
}
