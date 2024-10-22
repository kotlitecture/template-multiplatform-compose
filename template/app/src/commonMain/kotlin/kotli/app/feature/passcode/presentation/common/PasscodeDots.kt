package kotli.app.feature.passcode.presentation.common

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

@Composable
fun PasscodeDots(
    modifier: Modifier = Modifier,
    codeLength: Int,
    title: String? = null,
    getCode: () -> String?,
    getError: () -> String?
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        title?.let {
            AppText(
                modifier = Modifier.fillMaxWidth(),
                color = AppTheme.current.onSurface,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W600,
                fontSize = 24.sp,
                text = title
            )
        }
        DotsBlock(
            modifier = Modifier.fillMaxWidth(),
            codeLength = codeLength,
            getCode = getCode
        )
        Box(modifier = Modifier.heightIn(min = 24.dp)) {
            ErrorBlock(getError)
        }
    }
}

@Composable
private fun DotsBlock(
    modifier: Modifier = Modifier,
    getCode: () -> String?,
    codeLength: Int,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterHorizontally),
    ) {
        val value = getCode().orEmpty()
        repeat(codeLength) { idx -> DotBlock(idx <= value.length - 1) }
    }
}

@Composable
private fun ErrorBlock(
    getError: () -> String?
) {
    val error = getError() ?: return
    AppText(
        text = error,
        maxLines = 1,
        textAlign = TextAlign.Center,
        color = AppTheme.current.error
    )
}

@Composable
private fun DotBlock(filled: Boolean) {
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