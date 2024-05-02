package kotli.app.showcases.datasource.keyvalue.`object`

import kotli.app.showcases.ShowcaseItem
import kotli.app.showcases.ShowcasesViewModel
import shared.core.navigation.NavigationDestination

object ObjectKeyValueShowcase : ShowcaseItem {

    override val label: String = "Save and restore objects"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationState.onNext(ObjectKeyValueDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        ObjectKeyValueDestination
    )

}