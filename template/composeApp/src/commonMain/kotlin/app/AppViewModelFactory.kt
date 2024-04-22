package app

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

val AppViewModelFactory = viewModelFactory {
    initializer { AppViewModel() }
}