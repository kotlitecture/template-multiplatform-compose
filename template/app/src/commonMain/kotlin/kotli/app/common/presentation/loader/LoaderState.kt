package kotli.app.common.presentation.loader

import androidx.compose.runtime.Stable

@Stable
interface LoaderState {

    val loading: Boolean

}