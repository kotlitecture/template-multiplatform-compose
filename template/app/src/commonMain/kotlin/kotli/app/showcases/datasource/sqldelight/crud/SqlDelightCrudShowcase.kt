package kotli.app.showcases.datasource.sqldelight.crud

import kotli.app.showcases.ShowcaseItem
import kotli.app.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object SqlDelightCrudShowcase : ShowcaseItem {

    override val label: String = "SQL CRUD"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(SqlDelightCrudDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        SqlDelightCrudDestination
    )

}