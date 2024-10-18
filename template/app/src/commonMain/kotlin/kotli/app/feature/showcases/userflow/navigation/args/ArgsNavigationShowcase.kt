package kotli.app.feature.showcases.userflow.navigation.args

import kotli.app.feature.showcases.ShowcaseItem
import kotli.app.feature.showcases.ShowcasesViewModel
import kotli.app.feature.showcases.userflow.navigation.args.from.ArgsNavigationFromDestination
import kotli.app.feature.showcases.userflow.navigation.args.to.ArgsNavigationToDestination
import shared.presentation.navigation.NavigationDestination

object ArgsNavigationShowcase : kotli.app.feature.showcases.ShowcaseItem {

    override val label: String = "Navigation with arguments"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(ArgsNavigationFromDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        ArgsNavigationFromDestination,
        ArgsNavigationToDestination
    )

}