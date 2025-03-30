package kotli.app.showcases.presentation.dataflow.settings.primitive

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import shared.data.source.settings.SettingsSource
import shared.presentation.viewmodel.BaseViewModel

class PrimitiveSettingsViewModel(
    private val settingsSource: SettingsSource
) : BaseViewModel() {

    private val key = "my_primitive"
    private val _state = PrimitiveSettingsMutableState()
    val state: PrimitiveSettingsState = _state

    override fun doBind() = async("Restore text") {
        _state.text = settingsSource.read<String>(key).orEmpty()
    }

    fun onTextChanged(text: String) {
        _state.text = text
        async("Save changes", force = true) {
            settingsSource.save(key, text)
        }
    }

    private class PrimitiveSettingsMutableState : PrimitiveSettingsState {
        override var text: String by mutableStateOf("")
    }

}
