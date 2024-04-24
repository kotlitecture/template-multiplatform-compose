package app.showcases

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.appViewModel
import app.ui.component.basic.ActionButton
import app.ui.component.basic.AnyIcon
import app.ui.component.basic.Spacer16
import app.ui.container.FixedHeaderFooterLazyColumnLayout
import app.ui.container.FixedTopBarLazyColumnLayout
import core.ui.state.StoreObject
import core.ui.theme.material3.Material3ThemeData

/**
 * Composable function for displaying the showcases screen.
 * It displays a list of showcases along with a header and a hint block.
 */
@Composable
fun ShowcasesScreen() {
    val viewModel: ShowcasesViewModel = appViewModel(ShowcasesViewModel::class)
    val showcasesState = viewModel.showcasesStore.asStateNotNull()
    FixedTopBarLazyColumnLayout(
        title = "Showcases",
        actions = {
            ActionButton(
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                icon = Icons.Outlined.Info,
                onClick = viewModel::onShowHint,
            )
        },
        content = {
            item { Spacer16() }
            showcasesState.value.forEach { showcase ->
                when (showcase) {
                    is ShowcaseItem -> showcaseItem(showcase, viewModel)
                    is ShowcaseItemGroup -> showcaseItemGroup(showcase)
                }
            }
            item { Spacer16() }
        }
    )
    HintBlock(viewModel.hintStore)
}

@Composable
private fun HintBlock(hintStore: StoreObject<Boolean>) {
    if (!hintStore.asStateValueNotNull()) return
    AlertDialog(
        onDismissRequest = hintStore::clear,
        title = {
            Text(
                text = "Showcases"
            )
        },
        text = {
            Text(
                text = """
                Showcases are utilized to demonstrate features included in the generated project structure.
                
                Once everything is clear and you no longer require this screen, proceed with deletion:

                1. Package `app/showcases`.
                
                2. Usage of `ShowcasesDestination` in `app.AppNavigationRouter`.
                
                3. Usage of `ShowcasesDestination` in `app.di.state.ProvidesNavigationState`.
                
                4. Usage of `ShowcasesDestination` in `app.di.state.ProvidesNavigationBarState`.
            """.trimIndent()
            )
        },
        confirmButton = {
            TextButton(onClick = hintStore::clear) {
                Text(text = "Got it!")
            }
        }
    )
}

private fun LazyListScope.showcaseItem(
    showcase: ShowcaseItem,
    viewModel: ShowcasesViewModel
) {
    item {
        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = { showcase.onClick(viewModel) })
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = showcase.label)
                AnyIcon(model = Icons.Default.ChevronRight)
            }
        }
    }
}

private fun LazyListScope.showcaseItemGroup(
    showcase: ShowcaseItemGroup
) {
    item {
        Text(
            color = Material3ThemeData.current.colorScheme.primary,
            modifier = Modifier.padding(16.dp),
            fontWeight = FontWeight.W600,
            text = showcase.label,
            fontSize = 18.sp,
            maxLines = 1,
        )
    }
}