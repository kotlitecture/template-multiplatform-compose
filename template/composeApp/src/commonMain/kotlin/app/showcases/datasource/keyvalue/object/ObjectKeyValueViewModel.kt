package app.showcases.datasource.keyvalue.`object`

import app.datasource.keyvalue.AppKeyValueSource
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.skip
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import shared.core.BaseViewModel
import shared.core.navigation.NavigationState
import shared.core.state.StoreObject
import shared.data.serialization.JsonStrategy

class ObjectKeyValueViewModel(
    private val navigationState: NavigationState,
    private val keyValueSource: AppKeyValueSource
) : BaseViewModel() {

    val textStore = StoreObject<String>()
    val supportTextStore = StoreObject<String>()

    override fun doBind() {
        launchAsync("textStore") {
            val key = "my_object"
            val serializer = JsonStrategy.create(Data.serializer())
            val data: Data? = keyValueSource.read(key, serializer)
            data?.time?.let { updateSupportText(it) }
            textStore.set(data?.text)
            textStore.asFlow()
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
        supportTextStore.set("Last save time: $time")
    }

    fun onBack() {
        navigationState.onBack()
    }

    @Serializable
    data class Data(
        val text: String?,
        val time: Instant
    )

}
