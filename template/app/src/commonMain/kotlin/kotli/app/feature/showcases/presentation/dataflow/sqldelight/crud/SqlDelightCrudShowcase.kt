package kotli.app.feature.showcases.presentation.dataflow.sqldelight.crud

import kotli.app.feature.showcases.presentation.ShowcasesViewModel
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