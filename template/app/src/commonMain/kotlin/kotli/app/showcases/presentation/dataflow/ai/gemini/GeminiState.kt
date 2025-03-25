package kotli.app.showcases.presentation.dataflow.ai.gemini

import androidx.compose.runtime.Stable

@Stable
interface GeminiState {
    val replies: List<GeminiReply>
    val loading: Boolean
}

@Stable
interface GeminiReply {
    val prompt: String
    val reply: String
}