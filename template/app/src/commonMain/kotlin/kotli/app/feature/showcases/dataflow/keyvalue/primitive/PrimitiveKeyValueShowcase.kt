package kotli.app.feature.showcases.dataflow.keyvalue.primitive

import kotli.app.feature.showcases.ShowcaseItem
import kotli.app.feature.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object PrimitiveKeyValueShowcase : kotli.app.feature.showcases.ShowcaseItem {

    override val label: String = "Save and restore primitives"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(PrimitiveKeyValueDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        PrimitiveKeyValueDestination
    )

}