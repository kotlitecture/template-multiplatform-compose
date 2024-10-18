package kotli.app.feature.showcases.dataflow.keyvalue.`object`

import kotli.app.feature.showcases.ShowcaseItem
import kotli.app.feature.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object ObjectKeyValueShowcase : kotli.app.feature.showcases.ShowcaseItem {

    override val label: String = "Save and restore objects"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(ObjectKeyValueDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        ObjectKeyValueDestination
    )

}