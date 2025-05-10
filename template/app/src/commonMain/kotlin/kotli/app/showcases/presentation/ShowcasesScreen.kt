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
import shared.presentation.ui.component.DsActionButton
import shared.presentation.ui.component.DsAlertDialog
import shared.presentation.ui.component.DsIcon
import shared.presentation.ui.component.DsOutlinedCard
import shared.presentation.ui.component.DsSpacer16
import shared.presentation.ui.component.DsText
import shared.presentation.ui.component.DsTextPrimaryHeader
import shared.presentation.ui.container.DsFixedTopBarLazyColumn
import shared.presentation.ui.icon.DsIcons
import shared.presentation.viewmodel.provideViewModel

@Composable
fun ShowcasesScreen(
    onShow: (route: Any) -> Unit
) {
    val viewModel: ShowcasesViewModel = provideViewModel()
    val state = viewModel.state

    DsFixedTopBarLazyColumn(
        title = "Showcases",
        actions = {
            DsActionButton(
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                icon = DsIcons.info,
                onClick = viewModel::onShowHint,
            )
        },
        content = {
            item { DsSpacer16() }
            state.showcases.forEach { showcase ->
                when (showcase) {
                    is Showcase.Screen -> showcaseScreen(showcase, onShow)
                    is Showcase.Header -> showcaseHeader(showcase)
                }
            }
            item { DsSpacer16() }
        }
    )

    HintBlock(
        state = state,
        onHide = viewModel::onHideHint
    )
}

@Composable
fun ShowcaseHintBlock(text: String, modifier: Modifier = Modifier) {
    DsOutlinedCard(
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

    DsAlertDialog(
        onDismissRequest = onHide,
        title = "Showcases",
        text = """
                Showcases are utilized to demonstrate features included in the generated project structure.
                
                Once everything is clear and you no longer require this screen, proceed with deletion:

                1. Usage of `ShowcasesRoute` in `navigation.provide.presentation.NavigationViewModel`.
                
                2. Usage of `showcases()` in `AppConfig`.
                
                3. Package `showcases`.
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
        DsOutlinedCard(
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
                DsText(text = screen.label)
                DsIcon(model = DsIcons.chevronRight)
            }
        }
    }
}

private fun LazyListScope.showcaseHeader(
    header: Showcase.Header
) {
    item {
        DsTextPrimaryHeader(
            modifier = Modifier.padding(16.dp),
            text = header.label
        )
    }
}