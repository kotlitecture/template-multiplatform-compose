package core.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily

/**
 * Abstract class representing theme data.
 *
 * @property fontFamily The font family used in the theme.
 * @property primary The primary color in the theme.
 * @property onPrimary The color used for texts and icons on the primary background.
 */
@Immutable
abstract class ThemeData {

    abstract val providerId: String?
    abstract val dark: Boolean

    open val fontFamily: FontFamily = FontFamily.Default

    open val negative: Color = Color.Red
    open val primary: Color = Color.White
    open val onPrimary: Color = Color.Black

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
    class NoThemeData : ThemeData() {
        override val providerId: String? = null
        override val dark: Boolean = false
    }

    companion object {
        /** Local composition used to access the current theme data. */
        internal val localThemeData = staticCompositionLocalOf<ThemeData> { NoThemeData() }

        /** Returns the current theme data in the composition. */
        val current: ThemeData
            @Composable
            @ReadOnlyComposable
            get() = localThemeData.current
    }
}
