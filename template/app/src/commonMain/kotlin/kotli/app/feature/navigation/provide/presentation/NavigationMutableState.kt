package kotli.app.feature.navigation.provide.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotli.app.common.presentation.navigation.NavigationItem
import kotli.app.common.presentation.navigation.NavigationState

class NavigationMutableState : NavigationState {

    override var items: List<NavigationItem> by mutableStateOf(emptyList())
    override var selected: NavigationItem? by mutableStateOf(null)
    override var visible: Boolean? by mutableStateOf(null)

}