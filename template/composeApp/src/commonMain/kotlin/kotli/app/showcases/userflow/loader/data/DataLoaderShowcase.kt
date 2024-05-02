package kotli.app.showcases.userflow.loader.data

import kotli.app.showcases.ShowcaseItem
import kotli.app.showcases.ShowcasesViewModel
import shared.core.navigation.NavigationDestination

object DataLoaderShowcase : ShowcaseItem {

    override val label: String = "App Data Loader"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationState.onNext(DataLoaderShowcaseDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        DataLoaderShowcaseDestination
    )

}