package kotli.app.showcases.presentation.dataflow.ai.gemini

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import shared.presentation.ui.component.AppCard
import shared.presentation.ui.component.AppCircularProgressIndicator
import shared.presentation.ui.component.AppElevatedButton
import shared.presentation.ui.component.AppMarkdown
import shared.presentation.ui.component.AppTextField
import shared.presentation.ui.container.AppFixedTopBarLazyColumn
import shared.presentation.theme.Theme
import shared.presentation.viewmodel.provideViewModel

@Composable
fun GeminiScreen(onBack: () -> Unit) {
    val viewModel: GeminiViewModel = provideViewModel()
    val state = viewModel.state

    AppFixedTopBarLazyColumn(
        title = GeminiRoute.screen.label,
        onBack = onBack,
        footer = {
            PromptBlock(viewModel::onGenerateReply)
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
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AppCard(
            modifier = Modifier
                .align(Alignment.End)
                .clip(RoundedCornerShape(8.dp))
                .background(Theme.current.highlightSecondary)
        ) {
            AppMarkdown(
                modifier = Modifier.padding(8.dp),
                text = geminiReply.prompt
            )
        }
        AppMarkdown(text = geminiReply.reply)
    }
}

@Composable
private fun PromptBlock(onPrompt: (prompt: String?) -> Unit) {
    val promptState = remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Theme.current.bottomBlur)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AppTextField(
            modifier = Modifier
                .weight(1f),
            valueState = promptState,
            placeholder = "Enter your prompt"
        )

        AppElevatedButton(
            modifier = Modifier.wrapContentWidth(),
            onClick = {
                onPrompt(promptState.value)
                promptState.value = ""
            },
            text = "Enter",
        )
    }
}