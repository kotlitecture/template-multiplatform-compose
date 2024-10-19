package kotli.app.feature.showcases.presentation.dataflow.keyvalue.`object`

import kotli.app.feature.showcases.presentation.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object ObjectKeyValueShowcase : ShowcaseItem {

    override val label: String = "Save and restore objects"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(ObjectKeyValueDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        ObjectKeyValueDestination
    )

}