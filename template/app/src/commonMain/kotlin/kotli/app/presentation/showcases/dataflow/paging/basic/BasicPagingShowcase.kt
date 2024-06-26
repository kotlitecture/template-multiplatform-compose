package kotli.app.presentation.showcases.dataflow.paging.basic

import kotli.app.presentation.showcases.ShowcaseItem
import kotli.app.presentation.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object BasicPagingShowcase : ShowcaseItem {

    override val label: String = "Basic Paging Usage"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(BasicPagingDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        BasicPagingDestination
    )

}