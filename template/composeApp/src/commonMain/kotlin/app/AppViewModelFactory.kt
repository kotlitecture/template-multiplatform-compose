package app

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import core.ui.BaseViewModel
import core.ui.provideViewModel
import kotlin.reflect.KClass

val AppViewModelFactory = viewModelFactory {
    initializer { AppViewModel() }
}

@Composable
inline fun <VM : BaseViewModel> appViewModel(
    modelClass: KClass<VM>,
    key: String? = null,
): VM =
    provideViewModel(
        key = key,
        modelClass = modelClass,
        factory = AppViewModelFactory
    )