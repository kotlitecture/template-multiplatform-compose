package shared.design.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Outlined card with text content.
 *
 * @param modifier Modifier to be applied to the card.
 * @param text Text content to be displayed inside the card.
 */
@Composable
fun AppOutlinedCard(
    modifier: Modifier = Modifier,
    text: String
) {
    OutlinedCard(
        modifier = modifier,
        content = {
            AppText(
                modifier = Modifier.padding(16.dp),
                text = text
            )
        }
    )
}

/**
 * Outlined card with custom content.
 *
 * @param modifier Modifier to be applied to the card.
 * @param content Custom content to be displayed inside the card.
 */
@Composable
fun AppOutlinedCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    OutlinedCard(
        modifier = modifier,
        content = content
    )
}

/**
 * Card with custom content.
 *
 * @param modifier Modifier to be applied to the card.
 * @param content Custom content to be displayed inside the card.
 */
@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier,
        content = content
    )
}