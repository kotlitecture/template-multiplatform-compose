package kotli.app.feature.showcases.presentation.dataflow.keyvalue.primitive

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import shared.data.source.keyvalue.KeyValueSource
import shared.presentation.viewmodel.BaseViewModel

class PrimitiveKeyValueViewModel(
    private val keyValueSource: KeyValueSource
) : BaseViewModel() {

    private val key = "my_primitive"
    private val _state = PrimitiveKeyValueMutableState()
    val state: PrimitiveKeyValueState = _state

    override fun doBind() = async("Restore text") {
        _state.text = keyValueSource.read<String>(key).orEmpty()
    }

    fun onTextChanged(text: String) {
        _state.text = text
        async("Save changes", force = true) {
            keyValueSource.save(key, text)
        }
    }

    private class PrimitiveKeyValueMutableState : PrimitiveKeyValueState {
        override var text: String by mutableStateOf("")
    }

}
