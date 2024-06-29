package kotli.app.feature.navigation

import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationStore
import shared.presentation.store.DataState

class NavigationBarViewModel(
    private val navigationBarState: NavigationBarStore,
    private val navigationState: NavigationStore
) : BaseViewModel() {

    val restrictionState = DataState(true)
    val pagesState = navigationBarState.pagesState
    val visibilityState = navigationBarState.visibilityState
    val selectedPageState = navigationBarState.selectedPageState

    override fun doBind() {
        launchAsync("doBind") {
            val destStore = navigationState.currentDestinationState
            pagesState.asFlow()
                .filterNotNull()
                .map { pages -> pages.associateBy { it.id } }
                .flatMapLatest { pages -> destStore.asFlow().map { pages to it } }
                .collectLatest { pair ->
                    val restricted = navigationBarState.restrictedDestinations
                    val allowed = navigationBarState.allowedDestinations
                    val destination = pair.second
                    if (allowed.isNotEmpty()) {
                        restrictionState.set(!allowed.contains(destination))
                    } else if (restricted.isNotEmpty()) {
                        restrictionState.set(restricted.contains(destination))
                    } else {
                        restrictionState.set(false)
                    }
                    destination?.id
                        ?.let(pair.first::get)
                        ?.let(selectedPageState::set)
                }
        }
    }

}