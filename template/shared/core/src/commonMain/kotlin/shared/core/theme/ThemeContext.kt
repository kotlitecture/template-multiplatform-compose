package shared.core.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

/**
 * Theme context.
 */
@Immutable
open class ThemeContext {

    open val id: String? = null
    open val dark: Boolean = false

    @Composable
    open fun apply(config: ThemeConfig, content: @Composable () -> Unit) {
        content()
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
