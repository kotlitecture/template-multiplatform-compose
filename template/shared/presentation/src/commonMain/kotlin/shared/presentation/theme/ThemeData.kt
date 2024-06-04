package shared.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.font.FontFamily

@Immutable
data class ThemeData(
    val context: ThemeContext,
    val fontFamily: FontFamily
)