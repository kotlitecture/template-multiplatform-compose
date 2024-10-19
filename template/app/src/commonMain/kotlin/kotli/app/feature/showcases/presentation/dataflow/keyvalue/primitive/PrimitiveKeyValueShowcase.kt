package kotli.app.feature.showcases.presentation.dataflow.keyvalue.primitive

import kotli.app.feature.showcases.presentation.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object PrimitiveKeyValueShowcase : ShowcaseItem {

    override val label: String = "Save and restore primitives"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(PrimitiveKeyValueDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        PrimitiveKeyValueDestination
    )

}