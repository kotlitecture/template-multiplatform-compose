package shared.presentation.viewmodel

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import shared.presentation.theme.ThemeViewModel

internal val ViewModelFactory = viewModelFactory {
    initializer { ThemeViewModel() }
}