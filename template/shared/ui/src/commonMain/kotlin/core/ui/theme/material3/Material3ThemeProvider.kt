package core.ui.theme.material3

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

/**
 * Provides a Material3 theme based on the provided data.
 */
@Composable
fun Material3ThemeProvider(
    data: Material3ThemeData,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = data.colorScheme,
        typography = data.typography,
        content = content
    )
}