package kotli.app.showcases.datasource.keyvalue.primitive

import kotli.app.showcases.ShowcaseItem
import kotli.app.showcases.ShowcasesViewModel
import shared.core.navigation.NavigationDestination

object PrimitiveKeyValueShowcase : ShowcaseItem {

    override val label: String = "Save and restore primitives"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationState.onNext(PrimitiveKeyValueDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        PrimitiveKeyValueDestination
    )

}