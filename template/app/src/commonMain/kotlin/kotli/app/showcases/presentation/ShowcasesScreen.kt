package kotli.app.showcases.presentation

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
import kotli.app.showcases.domain.Showcase
import shared.presentation.ui.component.AppActionButton
import shared.presentation.ui.component.AppAlertDialog
import shared.presentation.ui.component.AppIcon
import shared.presentation.ui.component.AppOutlinedCard
import shared.presentation.ui.component.AppSpacer16
import shared.presentation.ui.component.AppText
import shared.presentation.ui.component.AppTextPrimaryHeader
import shared.presentation.ui.container.AppFixedTopBarLazyColumn
import shared.presentation.ui.icon.AppIcons
import shared.presentation.viewmodel.provideViewModel

@Composable
fun ShowcasesScreen(
    onShow: (route: Any) -> Unit
) {
    val viewModel: ShowcasesViewModel = provideViewModel()
    val state = viewModel.state

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
            state.showcases.forEach { showcase ->
                when (showcase) {
                    is Showcase.Screen -> showcaseScreen(showcase, onShow)
                    is Showcase.Header -> showcaseHeader(showcase)
                }
            }
            item { AppSpacer16() }
        }
    )

    HintBlock(
        state = state,
        onHide = viewModel::onHideHint
    )
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
private fun HintBlock(
    state: ShowcasesState,
    onHide: () -> Unit
) {
    if (!state.showHint) return

    AppAlertDialog(
        onDismissRequest = onHide,
        title = "Showcases",
        text = """
                Showcases are utilized to demonstrate features included in the generated project structure.
                
                Once everything is clear and you no longer require this screen, proceed with deletion:

                1. Usage of `ShowcasesRoute` in `feature.navigation.provide.presentation.NavigationViewModel`.
                
                2. Usage of `showcases()` in `AppConfig`.
                
                3. Package `feature.showcases`.
            """.trimIndent(),
        confirmLabel = "Got it!",
        confirmAction = onHide
    )
}

private fun LazyListScope.showcaseScreen(
    screen: Showcase.Screen,
    onShow: (route: Any) -> Unit
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
                    .clickable(onClick = { onShow(screen.route) })
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                AppText(text = screen.label)
                AppIcon(model = AppIcons.chevronRight)
            }
        }
    }
}

private fun LazyListScope.showcaseHeader(
    header: Showcase.Header
) {
    item {
        AppTextPrimaryHeader(
            modifier = Modifier.padding(16.dp),
            text = header.label
        )
    }
}