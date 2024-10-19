package kotli.app.feature.showcases.presentation.dataflow.encryption

import kotli.app.feature.showcases.presentation.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object BasicEncryptionShowcase : ShowcaseItem {

    override val label: String = "Basic Encryption Usage"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(BasicEncryptionDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        BasicEncryptionDestination
    )

}