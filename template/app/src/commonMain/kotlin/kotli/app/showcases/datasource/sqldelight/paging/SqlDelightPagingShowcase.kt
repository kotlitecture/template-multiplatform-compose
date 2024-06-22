package kotli.app.showcases.datasource.sqldelight.paging

import kotli.app.showcases.ShowcaseItem
import kotli.app.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object SqlDelightPagingShowcase : ShowcaseItem {

    override val label: String = "SQL Paging"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationState.onNext(SqlDelightPagingDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        SqlDelightPagingDestination
    )

}