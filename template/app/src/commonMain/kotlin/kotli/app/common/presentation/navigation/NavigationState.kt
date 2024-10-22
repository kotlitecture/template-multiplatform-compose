package kotli.app.common.presentation.navigation

import androidx.compose.runtime.Stable
import shared.design.container.AppNavigationState

@Stable
interface NavigationState : AppNavigationState {

    override val items: List<NavigationItem>

}