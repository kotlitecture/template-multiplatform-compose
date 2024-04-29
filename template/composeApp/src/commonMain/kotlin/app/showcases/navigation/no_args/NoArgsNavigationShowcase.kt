package app.showcases.navigation.no_args

import app.showcases.ShowcaseItem
import app.showcases.ShowcasesViewModel
import app.showcases.navigation.no_args.from.NoArgsNavigationFromDestination
import app.showcases.navigation.no_args.to.NoArgsNavigationToDestination
import shared.core.navigation.NavigationDestination

object NoArgsNavigationShowcase : ShowcaseItem {

    override val label: String = "Navigation without arguments"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationState.onNext(NoArgsNavigationFromDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        NoArgsNavigationFromDestination,
        NoArgsNavigationToDestination
    )

}