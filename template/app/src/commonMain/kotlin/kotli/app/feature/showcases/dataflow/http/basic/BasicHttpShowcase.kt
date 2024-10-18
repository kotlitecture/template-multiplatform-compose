package kotli.app.feature.showcases.dataflow.http.basic

import kotli.app.feature.showcases.ShowcaseItem
import kotli.app.feature.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object BasicHttpShowcase : kotli.app.feature.showcases.ShowcaseItem {

    override val label: String = "Basic Http Usage"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(BasicHttpDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        BasicHttpDestination
    )

}