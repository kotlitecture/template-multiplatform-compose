package kotli.app.presentation.showcases.datasource.http.basic

import kotli.app.presentation.showcases.ShowcaseItem
import kotli.app.presentation.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object BasicHttpShowcase : ShowcaseItem {

    override val label: String = "Basic Http Usage"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(BasicHttpDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        BasicHttpDestination
    )

}