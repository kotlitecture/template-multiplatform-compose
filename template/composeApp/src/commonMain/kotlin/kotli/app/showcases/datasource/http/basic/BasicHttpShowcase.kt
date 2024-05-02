package kotli.app.showcases.datasource.http.basic

import kotli.app.showcases.ShowcaseItem
import kotli.app.showcases.ShowcasesViewModel
import shared.core.navigation.NavigationDestination

object BasicHttpShowcase : ShowcaseItem {

    override val label: String = "Basic Http Usage"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationState.onNext(BasicHttpDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        BasicHttpDestination
    )

}