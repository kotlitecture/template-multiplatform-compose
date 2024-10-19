package kotli.app.feature.showcases.presentation.dataflow.keyvalue.primitive

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.drop
import shared.data.source.keyvalue.KeyValueSource
import shared.presentation.navigation.NavigationStore
import shared.presentation.viewmodel.BaseViewModel

class PrimitiveKeyValueViewModel(
    private val keyValueSource: KeyValueSource
) : BaseViewModel() {

    private val _state = PrimitiveKeyValueMutableState()
    val state: PrimitiveKeyValueState = _state

    override fun doBind() = async("Handle text changes") {
        val key = "my_primitive"
        _state.text = keyValueSource.read<String>(key).orEmpty()
        snapshotFlow { _state.text }
            .drop(1)
            .debounce(100)
            .collectLatest { text ->
                keyValueSource.save(key, text)
            }
    }

    fun onTextChanged(text: String) {
        _state.text = text
    }

    private class PrimitiveKeyValueMutableState : PrimitiveKeyValueState {
        override var text: String by mutableStateOf("")
    }

}
