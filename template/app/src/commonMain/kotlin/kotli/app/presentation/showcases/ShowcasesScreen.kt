package kotli.app.presentation.showcases

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shared.presentation.viewmodel.provideViewModel
import shared.presentation.store.DataState
import shared.design.component.AppActionButton
import shared.design.component.AppAlertDialog
import shared.design.component.AppIcon
import shared.design.component.AppOutlinedCard
import shared.design.component.AppSpacer16
import shared.design.component.AppText
import shared.design.component.AppTextPrimaryHeader
import shared.design.container.AppFixedTopBarLazyColumn
import shared.design.icon.AppIcons

/**
 * Composable function for displaying the showcases screen.
 * It displays a list of showcases along with a header and a hint block.
 */
@Composable
fun ShowcasesScreen() {
    val viewModel: ShowcasesViewModel = provideViewModel()
    val showcasesState = viewModel.showcasesState.asStateNotNull()
    AppFixedTopBarLazyColumn(
        title = "Showcases",
        actions = {
            AppActionButton(
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                icon = AppIcons.info,
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
    HintBlock(viewModel.hintState)
}

@Composable
fun ShowcaseHintBlock(text: String, modifier: Modifier = Modifier) {
    AppOutlinedCard(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .then(modifier),
        text = text
    )
}

@Composable
private fun HintBlock(hintStore: DataState<Boolean>) {
    if (!hintStore.asStateValueNotNull()) return
    AppAlertDialog(
        onDismissRequest = hintStore::clear,
        title = "Showcases",
        text = """
                Showcases are utilized to demonstrate features included in the generated project structure.
                
                Once everything is clear and you no longer require this screen, proceed with deletion:

                1. Package `presentation/showcases`.
                
                2. Usage of `ShowcasesDestination` in `presentation/app/AppNavigationRouter`.
                
                3. Usage of `ShowcasesDestination` in `di/presentation/NavigationModule`.
                
                4. Usage of `ShowcasesDestination` in `di/presentation/NavigationBarModule`.
                
                5. Usage of all view models associated with Showcases in `di/presentation/AppModule`.
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
                AppIcon(model = AppIcons.chevronRight)
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