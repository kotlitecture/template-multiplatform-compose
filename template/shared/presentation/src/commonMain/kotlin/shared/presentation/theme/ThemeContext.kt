package shared.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.font.FontFamily

/**
 * Theme context.
 */
@Immutable
open class ThemeContext {

    open val id: String? = null
    open val dark: Boolean = false

    @Composable
    open fun apply(
        fontFamily: FontFamily,
        content: @Composable () -> Unit
    ) {
        content()
    }

    @Composable
    fun apply(content: @Composable () -> Unit) {
        apply(FontFamily.Default, content)
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
