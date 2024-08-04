package kotli.app.presentation.passcode.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import shared.design.component.AppText
import shared.design.theme.AppTheme
import shared.presentation.store.DataState

/**
 * Composable function representing the passcode block.
 *
 * @param modifier Modifier to be applied to the passcode block.
 * @param codeState State representing the current passcode.
 * @param title Optional title for the passcode block.
 * @param errorState State representing any error message to display.
 * @param codeLength Length of the passcode.
 */
@Composable
fun PasscodeBlock(
    modifier: Modifier = Modifier,
    codeState: DataState<String>,
    errorState: DataState<String>? = null,
    title: String? = null,
    codeLength: Int = 4
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        title?.let {
            AppText(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W600,
                fontSize = 24.sp,
                text = title
            )
        }
        Passcode(
            modifier = Modifier.fillMaxWidth(),
            codeLength = codeLength,
            code = codeState
        )
        Box(modifier = Modifier.heightIn(min = 24.dp)) {
            errorState?.let { ErrorBlock(errorState) }
        }
    }
}

@Composable
private fun ErrorBlock(errorState: DataState<String>) {
    val error = errorState.asStateValue() ?: return
    AppText(
        text = error,
        maxLines = 1,
        textAlign = TextAlign.Center,
        color = AppTheme.current.error
    )
}

@Composable
private fun Passcode(
    modifier: Modifier = Modifier,
    code: DataState<String>,
    codeLength: Int,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterHorizontally),
    ) {
        val value = code.asStateValue().orEmpty()
        repeat(codeLength) { idx -> PasscodeDot(idx <= value.length - 1) }
    }
}

@Composable
private fun PasscodeDot(filled: Boolean) {
    val size = 16.dp
    Box(
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .composed {
                val color = AppTheme.current.onSurface
                if (filled) {
                    background(color)
                } else {
                    border(2.dp, color, CircleShape)
                }
            }
    )
}