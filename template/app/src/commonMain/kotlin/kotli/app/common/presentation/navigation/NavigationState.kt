package kotli.app.common.presentation.navigation

import androidx.compose.runtime.Stable
import shared.presentation.ui.container.DsNavigationState

@Stable
interface NavigationState : DsNavigationState {

    override val items: List<NavigationItem>

}