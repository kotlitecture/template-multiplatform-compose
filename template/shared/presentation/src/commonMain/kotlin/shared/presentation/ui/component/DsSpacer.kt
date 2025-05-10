package shared.presentation.ui.component

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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
@NonRestartableComposable
fun DsSpacer2() {
    Spacer(modifier = Modifier.size(2.dp))
}

@Composable
@NonRestartableComposable
fun DsSpacer4() {
    Spacer(modifier = Modifier.size(4.dp))
}

@Composable
@NonRestartableComposable
fun DsSpacer8() {
    Spacer(modifier = Modifier.size(8.dp))
}

@Composable
@NonRestartableComposable
fun DsSpacer12() {
    Spacer(modifier = Modifier.size(12.dp))
}

@Composable
@NonRestartableComposable
fun DsSpacer16() {
    Spacer(modifier = Modifier.size(16.dp))
}

@Composable
@NonRestartableComposable
fun DsSpacer32() {
    Spacer(modifier = Modifier.size(32.dp))
}

@Composable
@NonRestartableComposable
fun DsSpacerStatusBar(modifier: Modifier = Modifier) {
    Spacer(
        modifier = modifier
            .fillMaxWidth()
            .statusBarsPadding()
    )
}

@Composable
@NonRestartableComposable
fun DsSpacerNavigationBar(modifier: Modifier = Modifier) {
    Spacer(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
    )
}

@Composable
fun DsSpacerDynamic(modifier: Modifier = Modifier, heightState: State<Int>) {
    Spacer(
        modifier
            .height(with(LocalDensity.current) { heightState.value.toDp() })
    )
}
