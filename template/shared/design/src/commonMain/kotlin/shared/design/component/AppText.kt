package shared.design.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import shared.design.theme.AppThemeContext

@Composable
fun AppText(
    modifier: Modifier = Modifier,
    text: String?,
    textAlign: TextAlign? = null,
    color: Color = Color.Unspecified,
) {
    if (text == null) return
    Text(
        modifier = modifier,
        text = text,
        color = color,
        textAlign = textAlign,
    )
}

@Composable
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
fun AppTextPrimaryHeader(
    modifier: Modifier = Modifier,
    text: String
) {
    AppTextHeader(
        modifier = modifier,
        text = text,
        color = AppThemeContext.current.colorScheme.primary
    )
}
