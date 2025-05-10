package shared.presentation.ui.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
@NonRestartableComposable
fun DsCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier,
        content = content
    )
}

@Composable
@NonRestartableComposable
fun DsOutlinedCard(
    modifier: Modifier = Modifier,
    text: String
) {
    OutlinedCard(
        modifier = modifier,
        content = {
            DsText(
                modifier = Modifier.padding(16.dp),
                text = text
            )
        }
    )
}

@Composable
@NonRestartableComposable
fun DsOutlinedCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    OutlinedCard(
        modifier = modifier,
        content = content
    )
}