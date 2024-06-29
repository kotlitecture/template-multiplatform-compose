package kotli.app.showcases.datasource.keyvalue.primitive

import kotli.app.datasource.keyvalue.AppKeyValueSource
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.drop
import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationState
import shared.presentation.store.DataState

class PrimitiveKeyValueViewModel(
    private val navigationState: NavigationState,
    private val keyValueSource: AppKeyValueSource
) : BaseViewModel() {

    val textStore = DataState<String>()

    override fun doBind() {
        launchAsync("textStore") {
            val key = "my_primitive"
            textStore.set(keyValueSource.read(key))
            textStore.asFlow()
                .drop(1)
                .debounce(100)
                .collectLatest { text ->
                    keyValueSource.save(key, text)
                }
        }
    }

    fun onBack() {
        navigationState.onBack()
    }

}
