package kotli.app.feature.showcases.userflow.component.placeholder

import kotli.app.feature.showcases.ShowcaseItem
import kotli.app.feature.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object PlaceholderShowcase : kotli.app.feature.showcases.ShowcaseItem {

    override val label: String = "Placeholders"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(PlaceholderShowcaseDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        PlaceholderShowcaseDestination
    )

}