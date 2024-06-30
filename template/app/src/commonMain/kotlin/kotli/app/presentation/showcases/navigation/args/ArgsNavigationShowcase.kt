package kotli.app.presentation.showcases.navigation.args

import kotli.app.presentation.showcases.ShowcaseItem
import kotli.app.presentation.showcases.ShowcasesViewModel
import kotli.app.presentation.showcases.navigation.args.from.ArgsNavigationFromDestination
import kotli.app.presentation.showcases.navigation.args.to.ArgsNavigationToDestination
import shared.presentation.navigation.NavigationDestination

object ArgsNavigationShowcase : ShowcaseItem {

    override val label: String = "Navigation with arguments"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(ArgsNavigationFromDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        ArgsNavigationFromDestination,
        ArgsNavigationToDestination
    )

}