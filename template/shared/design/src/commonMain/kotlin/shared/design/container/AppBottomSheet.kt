package shared.design.container

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import shared.design.component.AppSpacerNavigationBar
import shared.design.theme.AppTheme

/**
 * Data class representing the appearance configuration for a bottom sheet.
 *
 * @param backgroundColor The background color of the bottom sheet.
 * @param shouldDismissOnBackPress Flag indicating whether the bottom sheet should be dismissed on back press.
 * @param fullscreen Flag indicating whether the bottom sheet should occupy the entire screen.
 */
data class AppBottomSheetAppearance(
    val backgroundColor: Color,
    val shouldDismissOnBackPress: Boolean,
    val fullscreen: Boolean
) {
    companion object {
        @Stable
        @Composable
        @ReadOnlyComposable
        fun default(
            backgroundColor: Color = AppTheme.current.surface,
            shouldDismissOnBackPress: Boolean = true,
            fullscreen: Boolean = false
        ): AppBottomSheetAppearance {
            return AppBottomSheetAppearance(
                shouldDismissOnBackPress = shouldDismissOnBackPress,
                backgroundColor = backgroundColor,
                fullscreen = fullscreen,
            )
        }
    }
}

/**
 * Composable function for rendering a bottom sheet layout.
 *
 * @param modifier The modifier to be applied to the bottom sheet.
 * @param appearance The appearance configuration for the bottom sheet.
 * @param onDismissRequest The callback to be invoked when the bottom sheet is dismissed.
 * @param content The content of the bottom sheet.
 */
@Composable
fun AppBottomSheet(
    modifier: Modifier = Modifier,
    appearance: AppBottomSheetAppearance = AppBottomSheetAppearance.default(),
    onDismissRequest: () -> Unit = {},
    content: @Composable ColumnScope.() -> Unit,
) {
    ModalBottomSheet(
        modifier = modifier,
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = appearance.fullscreen),
        windowInsets = WindowInsets.systemBars.only(WindowInsetsSides.Horizontal),
        properties = ModalBottomSheetDefaults.properties(
            shouldDismissOnBackPress = appearance.shouldDismissOnBackPress
        ),
        containerColor = appearance.backgroundColor,
        onDismissRequest = onDismissRequest,
        content = {
            content()
            AppSpacerNavigationBar()
        }
    )
}

