package kotli.app.feature.showcases.presentation.dataflow.ai.gemini

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot
import kotli.app.common.data.source.ai.AiSource
import shared.presentation.viewmodel.BaseViewModel

class GeminiViewModel(
    private val aiSource: AiSource
) : BaseViewModel() {

    private val _state = GeminiMutableState()
    val state: GeminiState = _state

    fun onGenerateReply(prompt: String?) {
        if (prompt.isNullOrBlank()) return
        async("Generate reply") {
            val reply = GeminiMutableReply(prompt)

            Snapshot.withMutableSnapshot {
                _state.loading = true
                _state.replies = _state.replies.plus(reply)
            }

            aiSource.reply(prompt).collect { geminiReply ->
                Snapshot.withMutableSnapshot {
                    _state.loading = false
                    reply.reply = reply.reply.plus(geminiReply)
                }
            }
        }
    }

    private class GeminiMutableState : GeminiState {
        override var replies: List<GeminiReply> by mutableStateOf(emptyList())
        override var loading: Boolean by mutableStateOf(false)
    }

    private class GeminiMutableReply(
        override val prompt: String
    ) : GeminiReply {
        override var reply: String by mutableStateOf("")
    }
}
