package kotli.app.feature.showcases.dataflow.paging.basic

import kotli.app.feature.showcases.ShowcaseItem
import kotli.app.feature.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object BasicPagingShowcase : kotli.app.feature.showcases.ShowcaseItem {

    override val label: String = "Basic Paging Usage"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(BasicPagingDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        BasicPagingDestination
    )

}