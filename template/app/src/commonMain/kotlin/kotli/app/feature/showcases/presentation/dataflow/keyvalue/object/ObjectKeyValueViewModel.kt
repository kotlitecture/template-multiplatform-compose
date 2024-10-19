package kotli.app.feature.showcases.presentation.dataflow.keyvalue.`object`

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.drop
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import shared.data.serialization.SerializationStrategy
import shared.data.source.keyvalue.KeyValueSource
import shared.presentation.navigation.NavigationStore
import shared.presentation.viewmodel.BaseViewModel

class ObjectKeyValueViewModel(
    private val navigationStore: NavigationStore,
    private val keyValueSource: KeyValueSource
) : BaseViewModel() {

    val textState = mutableStateOf("")
    val supportTextState = mutableStateOf("")

    override fun doBind() {
        val textFlow = snapshotFlow { textState.value }
        async("textStore") {
            val key = "my_object"
            val serializer = SerializationStrategy.json(Data.serializer())
            val data: Data? = keyValueSource.read(key, serializer)
            data?.time?.let { updateSupportText(it) }
            textState.value = data?.text.orEmpty()
            textFlow
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
    }

    private fun updateSupportText(time: Instant) {
        supportTextState.value = "Last save time: $time"
    }

    fun onBack() {
        navigationStore.onBack()
    }

    @Serializable
    data class Data(
        val text: String?,
        val time: Instant
    )

}
