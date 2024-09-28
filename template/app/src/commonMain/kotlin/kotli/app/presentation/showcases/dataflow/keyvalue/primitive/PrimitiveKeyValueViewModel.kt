package kotli.app.presentation.showcases.dataflow.keyvalue.primitive

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.drop
import shared.data.source.keyvalue.KeyValueSource
import shared.presentation.navigation.NavigationStore
import shared.presentation.viewmodel.BaseViewModel

class PrimitiveKeyValueViewModel(
    private val navigationStore: NavigationStore,
    private val keyValueSource: KeyValueSource
) : BaseViewModel() {

    val textState = mutableStateOf("")

    override fun doBind() {
        val textFlow = snapshotFlow { textState.value }
        launchAsync("textStore") {
            val key = "my_primitive"
            textState.value = keyValueSource.read<String>(key).orEmpty()
            textFlow
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
