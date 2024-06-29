package shared.presentation.misc

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Stable
@Composable
fun Dp.toPx() = with(LocalDensity.current) { toPx() }

@Stable
@Composable
fun Int.pxToDp() = with(LocalDensity.current) { toDp() }