package kotli.app.presentation.showcases.dataflow.sqldelight.paging

import kotli.app.presentation.showcases.ShowcaseItem
import kotli.app.presentation.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object SqlDelightPagingShowcase : ShowcaseItem {

    override val label: String = "SQL Paging"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(SqlDelightPagingDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        SqlDelightPagingDestination
    )

}