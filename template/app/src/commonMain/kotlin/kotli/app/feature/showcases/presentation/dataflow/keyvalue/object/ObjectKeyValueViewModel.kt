package kotli.app.feature.showcases.presentation.dataflow.keyvalue.`object`

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import shared.data.serialization.SerializationStrategy
import shared.data.source.keyvalue.KeyValueSource
import shared.presentation.viewmodel.BaseViewModel

class ObjectKeyValueViewModel(
    private val keyValueSource: KeyValueSource
) : BaseViewModel() {

    private val key = "my_object"
    private val serializer = SerializationStrategy.json(Data.serializer())

    private val _state = ObjectKeyValueMutableState()
    val state: ObjectKeyValueState = _state

    override fun doBind() = async("Restore text") {
        val data: Data? = keyValueSource.read(key, serializer)
        withState {
            _state.text = data?.text.orEmpty()
            data?.time?.let(::updateSupportText)
        }
    }

    fun onTextChanged(text: String) {
        _state.text = text
        async("Save changes", force = true) {
            val newData = Data(
                text = text,
                time = Clock.System.now()
            )
            keyValueSource.save(key, newData, serializer)
            updateSupportText(newData.time)
        }
    }

    private fun updateSupportText(time: Instant) {
        _state.supportText = "Last save time: $time"
    }

    @Serializable
    data class Data(
        val text: String?,
        val time: Instant
    )

    private class ObjectKeyValueMutableState : ObjectKeyValueState {
        override var text: String by mutableStateOf("")
        override var supportText: String by mutableStateOf("")
    }
}
