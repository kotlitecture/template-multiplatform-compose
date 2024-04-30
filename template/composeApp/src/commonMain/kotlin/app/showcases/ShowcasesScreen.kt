package app.showcases

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shared.core.provideViewModel
import shared.core.state.StoreObject
import shared.design.component.AppActionButton
import shared.design.component.AppAlertDialog
import shared.design.component.AppIcon
import shared.design.component.AppOutlinedCard
import shared.design.component.AppSpacer16
import shared.design.component.AppText
import shared.design.component.AppTextPrimaryHeader
import shared.design.container.AppFixedTopBarLazyColumn

/**
 * Composable function for displaying the showcases screen.
 * It displays a list of showcases along with a header and a hint block.
 */
@Composable
fun ShowcasesScreen() {
    val viewModel: ShowcasesViewModel = provideViewModel()
    val showcasesState = viewModel.showcasesStore.asStateNotNull()
    AppFixedTopBarLazyColumn(
        title = "Showcases",
        actions = {
            AppActionButton(
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                icon = Icons.Outlined.Info,
                onClick = viewModel::onShowHint,
            )
        },
        content = {
            item { AppSpacer16() }
            showcasesState.value.forEach { showcase ->
                when (showcase) {
                    is ShowcaseItem -> showcaseItem(showcase, viewModel)
                    is ShowcaseItemGroup -> showcaseItemGroup(showcase)
                }
            }
            item { AppSpacer16() }
        }
    )
    HintBlock(viewModel.hintStore)
}

@Composable
fun ShowcaseHintBlock(text: String) {
    AppOutlinedCard(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        text = text
    )
}

@Composable
private fun HintBlock(hintStore: StoreObject<Boolean>) {
    if (!hintStore.asStateValueNotNull()) return
    AppAlertDialog(
        onDismissRequest = hintStore::clear,
        title = "Showcases",
        text = """
                Showcases are utilized to demonstrate features included in the generated project structure.
                
                Once everything is clear and you no longer require this screen, proceed with deletion:

                1. Package `app/showcases`.
                
                2. Usage of `ShowcasesDestination` in `app.AppNavigationRouter`.
                
                3. Usage of `ShowcasesDestination` in `app.di.state.ProvidesNavigationState`.
                
                4. Usage of `ShowcasesDestination` in `app.di.state.ProvidesNavigationBarState`.
            """.trimIndent(),
        actionLabel = "Got it!",
        action = hintStore::clear
    )
}

private fun LazyListScope.showcaseItem(
    showcase: ShowcaseItem,
    viewModel: ShowcasesViewModel
) {
    item {
        AppOutlinedCard(
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
                AppText(text = showcase.label)
                AppIcon(model = Icons.Default.ChevronRight)
            }
        }
    }
}

private fun LazyListScope.showcaseItemGroup(
    showcase: ShowcaseItemGroup
) {
    item {
        AppTextPrimaryHeader(
            modifier = Modifier.padding(16.dp),
            text = showcase.label
        )
    }
}