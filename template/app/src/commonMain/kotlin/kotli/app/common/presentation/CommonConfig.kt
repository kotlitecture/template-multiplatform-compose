package kotli.app.common.presentation

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.lifecycle.viewmodel.initializer
import kotli.app.common.presentation.loader.LoaderViewModel
import kotli.app.di.inject

fun InitializerViewModelFactoryBuilder.common() {
    initializer { LoaderViewModel(inject()) }
}