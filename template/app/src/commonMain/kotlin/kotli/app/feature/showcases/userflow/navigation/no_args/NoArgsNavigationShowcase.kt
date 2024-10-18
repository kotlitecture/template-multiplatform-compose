package kotli.app.feature.showcases.userflow.navigation.no_args

import kotli.app.feature.showcases.ShowcaseItem
import kotli.app.feature.showcases.ShowcasesViewModel
import kotli.app.feature.showcases.userflow.navigation.no_args.from.NoArgsNavigationFromDestination
import kotli.app.feature.showcases.userflow.navigation.no_args.to.NoArgsNavigationToDestination
import shared.presentation.navigation.NavigationDestination

object NoArgsNavigationShowcase : kotli.app.feature.showcases.ShowcaseItem {

    override val label: String = "Navigation without arguments"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(NoArgsNavigationFromDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        NoArgsNavigationFromDestination,
        NoArgsNavigationToDestination
    )

}