package kotli.app.feature.navigation

import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationStore
import shared.presentation.store.DataState

class NavigationBarViewModel(
    private val navigationBarStore: NavigationBarStore,
    private val navigationStore: NavigationStore
) : BaseViewModel() {

    val restrictionState = DataState(true)
    val pagesState = navigationBarStore.pagesState
    val visibilityState = navigationBarStore.visibilityState
    val selectedPageState = navigationBarStore.selectedPageState

    override fun doBind() {
        launchAsync("doBind") {
            val destStore = navigationStore.currentDestinationState
            pagesState.asFlow()
                .filterNotNull()
                .map { pages -> pages.associateBy { it.id } }
                .flatMapLatest { pages -> destStore.asFlow().map { pages to it } }
                .collectLatest { pair ->
                    val restricted = navigationBarStore.restrictedDestinations
                    val allowed = navigationBarStore.allowedDestinations
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