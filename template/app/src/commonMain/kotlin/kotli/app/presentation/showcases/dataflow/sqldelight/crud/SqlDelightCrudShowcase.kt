package kotli.app.presentation.showcases.dataflow.sqldelight.crud

import kotli.app.presentation.showcases.ShowcaseItem
import kotli.app.presentation.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object SqlDelightCrudShowcase : ShowcaseItem {

    override val label: String = "SqlDelight CRUD"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(SqlDelightCrudDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        SqlDelightCrudDestination
    )

}