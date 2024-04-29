package app.showcases.navigation.args

import app.showcases.ShowcaseItem
import app.showcases.ShowcasesViewModel
import app.showcases.navigation.args.from.ArgsNavigationFromDestination
import app.showcases.navigation.args.to.ArgsNavigationToDestination
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