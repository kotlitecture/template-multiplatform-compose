package kotli.app.showcases.datasource.paging.basic

import kotli.app.showcases.ShowcaseItem
import kotli.app.showcases.ShowcasesViewModel
import shared.core.navigation.NavigationDestination

object BasicPagingShowcase : ShowcaseItem {

    override val label: String = "Basic Paging Usage"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationState.onNext(BasicPagingDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        BasicPagingDestination
    )

}