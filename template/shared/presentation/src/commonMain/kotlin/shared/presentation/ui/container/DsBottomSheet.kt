package shared.presentation.ui.container

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import shared.presentation.ui.component.DsSpacerNavigationBar
import shared.presentation.ui.theme.DsTheme

data class DsBottomSheetAppearance(
    val backgroundColor: Color,
    val shouldDismissOnBackPress: Boolean,
    val fullscreen: Boolean
) {
    companion object {
        @Stable
        @Composable
        @ReadOnlyComposable
        fun default(
            backgroundColor: Color = DsTheme.current.surface,
            shouldDismissOnBackPress: Boolean = true,
            fullscreen: Boolean = true
        ): DsBottomSheetAppearance {
            return DsBottomSheetAppearance(
                shouldDismissOnBackPress = shouldDismissOnBackPress,
                backgroundColor = backgroundColor,
                fullscreen = fullscreen,
            )
        }
    }
}

@Composable
@NonRestartableComposable
fun DsBottomSheet(
    modifier: Modifier = Modifier,
    appearance: DsBottomSheetAppearance = DsBottomSheetAppearance.default(),
    onDismissRequest: () -> Unit = {},
    content: @Composable ColumnScope.() -> Unit,
) {
    ModalBottomSheet(
        modifier = modifier,
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = appearance.fullscreen),
        contentWindowInsets = { WindowInsets.systemBars.only(WindowInsetsSides.Horizontal) },
        properties = remember(appearance.shouldDismissOnBackPress) {
            ModalBottomSheetProperties(
                shouldDismissOnBackPress = appearance.shouldDismissOnBackPress
            )
        },
        containerColor = appearance.backgroundColor,
        onDismissRequest = onDismissRequest,
        content = {
            content()
            DsSpacerNavigationBar()
        }
    )
}

