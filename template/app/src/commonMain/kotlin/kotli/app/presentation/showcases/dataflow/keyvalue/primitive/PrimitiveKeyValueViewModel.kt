package kotli.app.presentation.showcases.dataflow.keyvalue.primitive

import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.drop
import shared.data.source.keyvalue.KeyValueSource
import shared.presentation.navigation.NavigationStore
import shared.presentation.store.DataState
import shared.presentation.viewmodel.BaseViewModel

class PrimitiveKeyValueViewModel(
    private val navigationStore: NavigationStore,
    private val keyValueSource: KeyValueSource
) : BaseViewModel() {

    val textState = DataState<String>()

    override fun doBind() {
        launchAsync("textStore") {
            val key = "my_primitive"
            textState.set(keyValueSource.read(key))
            textState.asFlow()
                .drop(1)
                .debounce(100)
                .collectLatest { text ->
                    keyValueSource.save(key, text)
                }
        }
    }

    fun onBack() {
        navigationStore.onBack()
    }

}
