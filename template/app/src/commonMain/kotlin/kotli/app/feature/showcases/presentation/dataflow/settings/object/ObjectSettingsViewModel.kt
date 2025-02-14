package kotli.app.feature.showcases.presentation.dataflow.settings.`object`

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import shared.data.source.encoding.EncodingStrategy
import shared.data.source.settings.SettingsSource
import shared.presentation.viewmodel.BaseViewModel

class ObjectSettingsViewModel(
    private val settingsSource: SettingsSource
) : BaseViewModel() {

    private val key = "my_object"
    private val serializer = EncodingStrategy.json(Data.serializer())

    private val _state = ObjectSettingsMutableState()
    val state: ObjectSettingsState = _state

    override fun doBind() = async("Restore text") {
        val data: Data? = settingsSource.read(key, serializer)
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
            settingsSource.save(key, newData, serializer)
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

    private class ObjectSettingsMutableState : ObjectSettingsState {
        override var text: String by mutableStateOf("")
        override var supportText: String by mutableStateOf("")
    }
}
