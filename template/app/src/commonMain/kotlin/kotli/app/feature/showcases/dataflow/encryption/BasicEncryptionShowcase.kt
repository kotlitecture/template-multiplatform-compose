package kotli.app.feature.showcases.dataflow.encryption

import kotli.app.feature.showcases.ShowcaseItem
import kotli.app.feature.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object BasicEncryptionShowcase : kotli.app.feature.showcases.ShowcaseItem {

    override val label: String = "Basic Encryption Usage"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(BasicEncryptionDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        BasicEncryptionDestination
    )

}