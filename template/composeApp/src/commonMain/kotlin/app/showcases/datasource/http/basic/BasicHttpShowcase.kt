package app.showcases.datasource.http.basic

import app.showcases.ShowcaseItem
import app.showcases.ShowcasesViewModel
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