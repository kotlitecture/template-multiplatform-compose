package shared.core

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import shared.core.navigation.NavigationViewModel
import shared.core.theme.ThemeViewModel

internal val ViewModelFactory = viewModelFactory {
    initializer { ThemeViewModel() }
    initializer { NavigationViewModel() }
}