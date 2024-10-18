package kotli.app.feature.showcases.dataflow.sqldelight.crud

import kotli.app.feature.showcases.ShowcaseItem
import kotli.app.feature.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object SqlDelightCrudShowcase : kotli.app.feature.showcases.ShowcaseItem {

    override val label: String = "SqlDelight CRUD"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(SqlDelightCrudDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        SqlDelightCrudDestination
    )

}