package kotli.app.feature.showcases.dataflow.ai.gemini

import kotli.app.common.data.source.ai.AiSource
import shared.presentation.navigation.NavigationStore
import shared.presentation.store.DataState
import shared.presentation.viewmodel.BaseViewModel

class GeminiViewModel(
    private val navigationStore: NavigationStore,
    private val aiSource: AiSource
) : BaseViewModel() {

    val state = DataState(GeminiState())

    fun onBack() {
        navigationStore.onBack()
    }

    fun onGenerateReply(prompt: String?) = async("Generate reply") {
        if (prompt.isNullOrBlank()) return@async
        val geminiReply = GeminiReply(prompt = prompt)
        state.update { current ->
            current!!.copy(
                loading = true,
                replies = current.replies.plus(geminiReply)
            )
        }
        aiSource.reply(prompt).collect { reply ->
            geminiReply.replyState.update { it?.plus(reply) ?: reply }
            state.update { current ->
                current!!.copy(
                    loading = false
                )
            }
        }
    }
}
