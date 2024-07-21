package kotli.app.presentation.showcases.userflow.component.placeholder

import kotli.app.presentation.showcases.ShowcaseItem
import kotli.app.presentation.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object PlaceholderShowcase : ShowcaseItem {

    override val label: String = "Placeholders"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(PlaceholderShowcaseDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        PlaceholderShowcaseDestination
    )

}