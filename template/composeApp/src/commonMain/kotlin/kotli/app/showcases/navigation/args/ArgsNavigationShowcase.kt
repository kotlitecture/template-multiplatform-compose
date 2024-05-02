package kotli.app.showcases.navigation.args

import kotli.app.showcases.ShowcaseItem
import kotli.app.showcases.ShowcasesViewModel
import kotli.app.showcases.navigation.args.from.ArgsNavigationFromDestination
import kotli.app.showcases.navigation.args.to.ArgsNavigationToDestination
import shared.core.navigation.NavigationDestination

object ArgsNavigationShowcase : ShowcaseItem {

    override val label: String = "Navigation with arguments"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationState.onNext(ArgsNavigationFromDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        ArgsNavigationFromDestination,
        ArgsNavigationToDestination
    )

}