package kotli.app.feature.showcases.dataflow.cache.basic

import kotli.app.feature.showcases.ShowcaseItem
import kotli.app.feature.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object BasicCacheShowcase : kotli.app.feature.showcases.ShowcaseItem {

    override val label: String = "Basic In-Memory Cache Usage"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(kotli.app.feature.showcases.dataflow.cache.basic.BasicCacheDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        kotli.app.feature.showcases.dataflow.cache.basic.BasicCacheDestination
    )

}