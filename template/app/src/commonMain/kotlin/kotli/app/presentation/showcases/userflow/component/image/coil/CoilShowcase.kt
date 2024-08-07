package kotli.app.presentation.showcases.userflow.component.image.coil

import kotli.app.presentation.showcases.ShowcaseItem
import kotli.app.presentation.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object CoilShowcase : ShowcaseItem {

    override val label: String = "Coil Image Library"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(CoilShowcaseDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        CoilShowcaseDestination
    )

}