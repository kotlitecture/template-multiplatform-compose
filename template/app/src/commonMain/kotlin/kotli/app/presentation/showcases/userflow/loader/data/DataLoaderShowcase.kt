package kotli.app.presentation.showcases.userflow.loader.data

import kotli.app.presentation.showcases.ShowcaseItem
import kotli.app.presentation.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object DataLoaderShowcase : ShowcaseItem {

    override val label: String = "App Data Loader"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(DataLoaderShowcaseDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        DataLoaderShowcaseDestination
    )

}