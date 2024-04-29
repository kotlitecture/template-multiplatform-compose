package app.showcases.datasource.paging.basic

import app.showcases.ShowcaseItem
import app.showcases.ShowcasesViewModel
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