package kotli.app.presentation.showcases.datasource.cache.basic

import kotli.app.presentation.showcases.ShowcaseItem
import kotli.app.presentation.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object BasicCacheShowcase : ShowcaseItem {

    override val label: String = "Basic In-Memory Cache Usage"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(kotli.app.presentation.showcases.datasource.cache.basic.BasicCacheDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        kotli.app.presentation.showcases.datasource.cache.basic.BasicCacheDestination
    )

}