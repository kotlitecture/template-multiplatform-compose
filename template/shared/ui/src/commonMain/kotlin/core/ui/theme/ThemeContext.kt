package core.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

/**
 * Theme context.
 */
@Immutable
open class ThemeContext {

    open val id: String? = null
    open val dark: Boolean = false

    open val negative: Color = Color.Red
    open val primary: Color = Color.White
    open val onPrimary: Color = Color.Black

    @Composable
    open fun apply(config: ThemeConfig, content: @Composable () -> Unit) {
        content()
    }

    val topBlur by lazy {
        Brush.verticalGradient(
            listOf(
                primary,
                primary.copy(alpha = 0.9f),
                primary.copy(alpha = 0.7f),
                primary.copy(alpha = 0.5f),
            )
        )
    }

    open val bottomBlur by lazy {
        Brush.verticalGradient(
            listOf(
                primary.copy(alpha = 0.5f),
                primary.copy(alpha = 0.7f),
                primary.copy(alpha = 0.9f),
                primary
            )
        )
    }

    /** Represents no theme data. */
    class NoThemeContext : ThemeContext()

    companion object {
        /** Local composition used to access the current theme data. */
        internal val localThemeContext = staticCompositionLocalOf<ThemeContext> { NoThemeContext() }

        /** Returns the current theme data in the composition. */
        val current: ThemeContext
            @Composable
            @ReadOnlyComposable
            get() = localThemeContext.current
    }
}
