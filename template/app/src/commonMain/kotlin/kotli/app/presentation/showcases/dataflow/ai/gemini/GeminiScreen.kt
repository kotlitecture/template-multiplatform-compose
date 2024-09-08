package kotli.app.presentation.showcases.dataflow.ai.gemini

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import shared.design.component.AppCard
import shared.design.component.AppCircularProgressIndicator
import shared.design.component.AppElevatedButton
import shared.design.component.AppMarkdown
import shared.design.component.AppTextField
import shared.design.container.AppFixedTopBarLazyColumn
import shared.design.theme.AppTheme
import shared.presentation.viewmodel.provideViewModel

@Composable
fun GeminiScreen() {
    val viewModel: GeminiViewModel = provideViewModel()
    val state = viewModel.state.asStateValueNotNull()

    AppFixedTopBarLazyColumn(
        title = GeminiShowcase.label,
        onBack = viewModel::onBack,
        footer = {
            PromptBlock(state, viewModel::onGenerateReply)
        },
        content = {
            state.replies.forEach { reply ->
                item {
                    ReplyBlock(reply)
                }
            }
            if (state.loading) {
                item { LoadingBlock() }
            }
        },
    )
}

@Composable
private fun LoadingBlock() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        AppCircularProgressIndicator(size = 32.dp)
    }
}

@Composable
private fun ReplyBlock(geminiReply: GeminiReply) {
    val reply = geminiReply.replyState.asStateValue() ?: return
    AppCard(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(AppTheme.current.highlightSecondary)
    ) {
        AppMarkdown(
            modifier = Modifier.padding(8.dp),
            text = reply
        )
    }
}

@Composable
private fun PromptBlock(state: GeminiState, onPrompt: (prompt: String?) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppTheme.current.bottomBlur)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AppTextField(
            modifier = Modifier
                .weight(1f),
            valueState = state.promptState,
            placeholder = "Enter your prompt"
        )

        AppElevatedButton(
            modifier = Modifier.wrapContentWidth(),
            onClick = {
                onPrompt(state.getPrompt())
                state.promptState.clear()
            },
            text = "Enter",
        )
    }
}