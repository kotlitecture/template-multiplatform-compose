package kotli.app.presentation.showcases.dataflow.ai.gemini

import shared.presentation.store.DataState

data class GeminiState(
    val promptState: DataState<String> = DataState(),
    val replies: List<GeminiReply> = emptyList(),
    val loading: Boolean = false
) {

    fun getPrompt(): String? {
        return promptState.get()
    }

}

data class GeminiReply(
    val replyState: DataState<String> = DataState()
)