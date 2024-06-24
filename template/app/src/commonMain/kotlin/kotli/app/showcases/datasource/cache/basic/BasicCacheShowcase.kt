package kotli.app.showcases.datasource.cache.basic

import kotli.app.showcases.ShowcaseItem
import kotli.app.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object BasicCacheShowcase : ShowcaseItem {

    override val label: String = "Basic In-Memory Cache Usage"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationState.onNext(BasicCacheDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        BasicCacheDestination
    )

}