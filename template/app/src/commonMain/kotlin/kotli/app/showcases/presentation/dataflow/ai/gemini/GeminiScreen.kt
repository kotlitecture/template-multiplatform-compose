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
import shared.presentation.ui.component.DsCard
import shared.presentation.ui.component.DsCircularProgressIndicator
import shared.presentation.ui.component.DsElevatedButton
import shared.presentation.ui.component.DsMarkdown
import shared.presentation.ui.component.DsTextField
import shared.presentation.ui.container.DsFixedTopBarLazyColumn
import shared.presentation.ui.theme.DsTheme
import shared.presentation.viewmodel.provideViewModel

@Composable
fun GeminiScreen(onBack: () -> Unit) {
    val viewModel: GeminiViewModel = provideViewModel()
    val state = viewModel.state

    DsFixedTopBarLazyColumn(
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
        DsCircularProgressIndicator(size = 32.dp)
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
        DsCard(
            modifier = Modifier
                .align(Alignment.End)
                .clip(RoundedCornerShape(8.dp))
                .background(DsTheme.current.highlightSecondary)
        ) {
            DsMarkdown(
                modifier = Modifier.padding(8.dp),
                text = geminiReply.prompt
            )
        }
        DsMarkdown(text = geminiReply.reply)
    }
}

@Composable
private fun PromptBlock(onPrompt: (prompt: String?) -> Unit) {
    val promptState = remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(DsTheme.current.bottomBlur)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        DsTextField(
            modifier = Modifier
                .weight(1f),
            valueState = promptState,
            placeholder = "Enter your prompt"
        )

        DsElevatedButton(
            modifier = Modifier.wrapContentWidth(),
            onClick = {
                onPrompt(promptState.value)
                promptState.value = ""
            },
            text = "Enter",
        )
    }
}