package core.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import core.ui.navigation.NavigationViewModel
import core.ui.theme.ThemeViewModel
import kotlin.reflect.KClass

internal val CoreViewModelFactory = viewModelFactory {
    initializer { NavigationViewModel() }
    initializer { ThemeViewModel() }
}

@Composable
internal fun <VM : BaseViewModel> coreViewModel(
    modelClass: KClass<VM>,
    key: String? = null,
): VM =
    provideViewModel(
        key = key,
        modelClass = modelClass,
        factory = CoreViewModelFactory
    )