package shared.design.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import shared.design.theme.AppTheme
import shared.presentation.store.DataState

@Composable
fun AppText(
    modifier: Modifier = Modifier,
    text: String?,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
) {
    if (text == null) return
    Text(
        modifier = modifier,
        text = text,
        color = color,
        maxLines = maxLines,
        textAlign = textAlign,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight
    )
}

@Composable
@NonRestartableComposable
fun AppText(
    modifier: Modifier = Modifier,
    textState: DataState<String>,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
) {
    AppText(
        modifier = modifier,
        text = textState.asStateValue(),
        maxLines = maxLines,
        textAlign = textAlign,
        color = color,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight
    )
}

@Composable
@NonRestartableComposable
fun AppTextHeader(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Unspecified,
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        fontSize = 18.sp,
        fontWeight = FontWeight.W600
    )
}

@Composable
@NonRestartableComposable
fun AppTextPrimaryHeader(
    modifier: Modifier = Modifier,
    text: String
) {
    AppTextHeader(
        modifier = modifier,
        text = text,
        color = AppTheme.current.colorScheme.primary
    )
}
