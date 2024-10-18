package kotli.app.feature.showcases.dataflow.sqldelight.paging

import kotli.app.feature.showcases.ShowcaseItem
import kotli.app.feature.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object SqlDelightPagingShowcase : kotli.app.feature.showcases.ShowcaseItem {

    override val label: String = "SqlDelight Paging"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(SqlDelightPagingDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        SqlDelightPagingDestination
    )

}