package kotli.app.presentation.showcases.dataflow.keyvalue.`object`

import kotli.app.data.source.keyvalue.AppKeyValueSource
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.drop
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationStore
import shared.presentation.store.DataState
import shared.data.serialization.SerializationStrategy

class ObjectKeyValueViewModel(
    private val navigationStore: NavigationStore,
    private val keyValueSource: AppKeyValueSource
) : BaseViewModel() {

    val textState = DataState<String>()
    val supportTextState = DataState<String>()

    override fun doBind() {
        launchAsync("textStore") {
            val key = "my_object"
            val serializer = SerializationStrategy.json(Data.serializer())
            val data: Data? = keyValueSource.read(key, serializer)
            data?.time?.let { updateSupportText(it) }
            textState.set(data?.text)
            textState.asFlow()
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
        supportTextState.set("Last save time: $time")
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
