package kotli.app.presentation.showcases.datasource.keyvalue.primitive

import kotli.app.presentation.showcases.ShowcaseItem
import kotli.app.presentation.showcases.ShowcasesViewModel
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