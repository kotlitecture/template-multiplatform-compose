package kotli.app.presentation.showcases.userflow.component.markdown

import kotli.app.presentation.showcases.ShowcaseItem
import kotli.app.presentation.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object MarkdownShowcase : ShowcaseItem {

    override val label: String = "Markdown Text"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(MarkdownShowcaseDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        MarkdownShowcaseDestination
    )

}