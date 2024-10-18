package kotli.app.feature.showcases.userflow.component.image.coil

import kotli.app.feature.showcases.ShowcaseItem
import kotli.app.feature.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object CoilShowcase : kotli.app.feature.showcases.ShowcaseItem {

    override val label: String = "Coil Image Library"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(CoilShowcaseDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        CoilShowcaseDestination
    )

}