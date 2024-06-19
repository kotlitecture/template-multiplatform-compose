package kotli.app.showcases.datasource.sqlight.paging

import kotli.app.showcases.ShowcaseItem
import kotli.app.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object SqlDelightPagingShowcase : ShowcaseItem {

    override val label: String = "Paging on an SQL table"

    override fun onClick(viewModel: ShowcasesViewModel) {
//        viewModel.navigationState.onNext()
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(

    )

}