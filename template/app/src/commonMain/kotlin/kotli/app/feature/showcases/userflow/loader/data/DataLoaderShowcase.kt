package kotli.app.feature.showcases.userflow.loader.data

import kotli.app.feature.showcases.ShowcaseItem
import kotli.app.feature.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object DataLoaderShowcase : kotli.app.feature.showcases.ShowcaseItem {

    override val label: String = "App Data Loader"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(DataLoaderShowcaseDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        DataLoaderShowcaseDestination
    )

}