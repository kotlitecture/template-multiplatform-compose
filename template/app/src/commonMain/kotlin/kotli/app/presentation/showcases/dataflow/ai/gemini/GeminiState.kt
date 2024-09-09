package kotli.app.presentation.showcases.dataflow.ai.gemini

import shared.presentation.store.DataState

data class GeminiState(
    val replies: List<GeminiReply> = emptyList(),
    val loading: Boolean = false
)

data class GeminiReply(
    val prompt: String,
    val replyState: DataState<String> = DataState()
)