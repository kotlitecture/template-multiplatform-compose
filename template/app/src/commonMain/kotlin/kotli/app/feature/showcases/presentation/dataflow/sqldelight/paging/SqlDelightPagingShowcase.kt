package kotli.app.feature.showcases.presentation.dataflow.sqldelight.paging

import kotli.app.feature.showcases.presentation.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object SqlDelightPagingShowcase : ShowcaseItem {

    override val label: String = "SqlDelight Paging"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(SqlDelightPagingDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        SqlDelightPagingDestination
    )

}