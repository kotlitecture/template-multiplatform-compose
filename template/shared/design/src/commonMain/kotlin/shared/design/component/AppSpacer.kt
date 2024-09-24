package shared.design.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shared.presentation.misc.pxToDp

/**
 * Spacer with 2dp size.
 */
@Composable
@NonRestartableComposable
fun AppSpacer2() {
    Spacer(modifier = Modifier.size(2.dp))
}

/**
 * Spacer with 4dp size.
 */
@Composable
@NonRestartableComposable
fun AppSpacer4() {
    Spacer(modifier = Modifier.size(4.dp))
}

/**
 * Spacer with 4dp size.
 */
@Composable
@NonRestartableComposable
fun AppSpacer8() {
    Spacer(modifier = Modifier.size(8.dp))
}

/**
 * Spacer with 12dp size.
 */
@Composable
@NonRestartableComposable
fun AppSpacer12() {
    Spacer(modifier = Modifier.size(12.dp))
}

/**
 * Spacer with 16dp size.
 */
@Composable
@NonRestartableComposable
fun AppSpacer16() {
    Spacer(modifier = Modifier.size(16.dp))
}

/**
 * Spacer filling the status bar height.
 *
 * @param modifier Modifier to be applied to the spacer.
 */
@Composable
@NonRestartableComposable
fun AppSpacerStatusBar(modifier: Modifier = Modifier) {
    Spacer(
        modifier = modifier
            .fillMaxWidth()
            .statusBarsPadding()
    )
}

/**
 * Spacer filling the navigation bar height.
 */
@Composable
@NonRestartableComposable
fun AppSpacerNavigationBar(modifier: Modifier = Modifier) {
    Spacer(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
    )
}

/**
 * Spacer with dynamic height.
 *
 * @param modifier Modifier to be applied to the spacer.
 * @param heightState State representing the height of the spacer.
 */
@Composable
fun AppSpacerDynamic(modifier: Modifier = Modifier, heightState: State<Int>) {
    Spacer(
        modifier
            .height(heightState.value.pxToDp())
            .fillMaxWidth()
    )
}
