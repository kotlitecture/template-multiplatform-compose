package kotli.app.feature.showcases.userflow.component.markdown

import kotli.app.feature.showcases.ShowcaseItem
import kotli.app.feature.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object MarkdownShowcase : kotli.app.feature.showcases.ShowcaseItem {

    override val label: String = "Markdown Text"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(MarkdownShowcaseDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        MarkdownShowcaseDestination
    )

}