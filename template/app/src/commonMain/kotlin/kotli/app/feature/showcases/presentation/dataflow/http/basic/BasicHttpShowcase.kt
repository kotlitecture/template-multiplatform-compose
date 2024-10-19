package kotli.app.feature.showcases.presentation.dataflow.http.basic

import kotli.app.feature.showcases.presentation.ShowcasesViewModel
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