package app.ui.component.basic

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.ui.misc.extensions.pxToDp

/**
 * Spacer with 2dp size.
 */
@Composable
fun Spacer2() {
    Spacer(modifier = Modifier.size(2.dp))
}

/**
 * Spacer with 4dp size.
 */
@Composable
fun Spacer4() {
    Spacer(modifier = Modifier.size(4.dp))
}

/**
 * Spacer with 4dp size.
 */
@Composable
fun Spacer8() {
    Spacer(modifier = Modifier.size(8.dp))
}

/**
 * Spacer with 12dp size.
 */
@Composable
fun Spacer12() {
    Spacer(modifier = Modifier.size(12.dp))
}

/**
 * Spacer with 16dp size.
 */
@Composable
fun Spacer16() {
    Spacer(modifier = Modifier.size(16.dp))
}

/**
 * Spacer filling the status bar height.
 *
 * @param modifier Modifier to be applied to the spacer.
 */
@Composable
fun SpacerStatusBar(modifier: Modifier = Modifier) {
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
fun SpacerNavigationBar(modifier: Modifier = Modifier) {
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
fun SpacerDynamic(modifier: Modifier = Modifier, heightState: State<Int>) {
    Spacer(
        modifier
            .height(heightState.value.pxToDp())
            .fillMaxWidth()
    )
}
