package kotli.app.presentation.showcases.dataflow.ai.gemini

import kotli.app.presentation.showcases.ShowcaseItem
import kotli.app.presentation.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object GeminiShowcase : ShowcaseItem {

    override val label: String = "Gemini AI"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(GeminiDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        GeminiDestination
    )

}