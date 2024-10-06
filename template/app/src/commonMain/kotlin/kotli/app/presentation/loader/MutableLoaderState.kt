package kotli.app.presentation.loader

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

internal class MutableLoaderState : LoaderState {

    override var loading: Boolean by mutableStateOf(false)

}