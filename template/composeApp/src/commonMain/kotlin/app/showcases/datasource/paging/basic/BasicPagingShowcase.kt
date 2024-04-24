package app.showcases.datasource.paging.basic

import app.showcases.ShowcaseItem
import app.showcases.ShowcasesViewModel
import core.ui.navigation.NavigationDestination

object BasicPagingShowcase : ShowcaseItem {

    override val label: String = "Basic Paging Source"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationState.onNext(BasicPagingDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        BasicPagingDestination
    )

}