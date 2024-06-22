package kotli.app.feature.navigation

import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import shared.presentation.BaseViewModel
import shared.presentation.navigation.NavigationState
import shared.presentation.state.StoreObject

class NavigationBarViewModel(
    private val navigationBarState: NavigationBarState,
    private val navigationState: NavigationState
) : BaseViewModel() {

    val restrictionStore = StoreObject(true)
    val pagesStore = navigationBarState.pagesStore
    val visibilityStore = navigationBarState.visibilityStore
    val selectedPageStore = navigationBarState.selectedPageStore

    override fun doBind() {
        launchAsync("doBind") {
            val destStore = navigationState.currentDestinationStore
            pagesStore.asFlow()
                .filterNotNull()
                .map { pages -> pages.associateBy { it.id } }
                .flatMapLatest { pages -> destStore.asFlow().map { pages to it } }
                .collectLatest { pair ->
                    val restricted = navigationBarState.restrictedDestinations
                    val allowed = navigationBarState.allowedDestinations
                    val destination = pair.second
                    if (allowed.isNotEmpty()) {
                        restrictionStore.set(!allowed.contains(destination))
                    } else if (restricted.isNotEmpty()) {
                        restrictionStore.set(restricted.contains(destination))
                    } else {
                        restrictionStore.set(false)
                    }
                    destination?.id
                        ?.let(pair.first::get)
                        ?.let(selectedPageStore::set)
                }
        }
    }

}