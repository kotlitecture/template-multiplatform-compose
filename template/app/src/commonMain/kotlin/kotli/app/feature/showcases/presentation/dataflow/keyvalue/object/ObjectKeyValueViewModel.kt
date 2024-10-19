package kotli.app.feature.showcases.presentation.dataflow.keyvalue.`object`

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.runtime.snapshots.Snapshot
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.drop
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import shared.data.serialization.SerializationStrategy
import shared.data.source.keyvalue.KeyValueSource
import shared.presentation.viewmodel.BaseViewModel

class ObjectKeyValueViewModel(
    private val keyValueSource: KeyValueSource
) : BaseViewModel() {

    private val _state = ObjectKeyValueMutableState()
    val state: ObjectKeyValueState = _state

    override fun doBind() = async("Handle input changes") {
        val key = "my_object"
        val serializer = SerializationStrategy.json(Data.serializer())
        val data: Data? = keyValueSource.read(key, serializer)

        Snapshot.withMutableSnapshot {
            data?.time?.let(::updateSupportText)
            _state.text = data?.text.orEmpty()
        }

        snapshotFlow { _state.text }
            .drop(1)
            .debounce(100)
            .collectLatest { text ->
                val newData = Data(
                    text = text,
                    time = Clock.System.now()
                )
                keyValueSource.save(key, newData, serializer)
                updateSupportText(newData.time)
            }
    }

    fun onTextChanged(text: String) {
        _state.text = text
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
