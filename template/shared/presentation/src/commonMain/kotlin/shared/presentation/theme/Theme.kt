package shared.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

@Immutable
abstract class Theme {

    abstract val id: String
    abstract val dark: Boolean

    @Composable
    abstract fun apply(state: ThemeState, content: @Composable () -> Unit)

    companion object {
        internal val localThemeContext = staticCompositionLocalOf<Theme> { NoTheme }

        val current: Theme
            @Composable
            @ReadOnlyComposable
            get() = localThemeContext.current
    }
}

private object NoTheme : Theme() {

    override val id: String = ""
    override val dark: Boolean = false

    @Composable
    override fun apply(state: ThemeState, content: @Composable () -> Unit) {
        content()
    }
}
