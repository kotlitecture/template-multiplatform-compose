package kotli.app.feature.showcases.dataflow.ai.gemini

import kotli.app.feature.showcases.ShowcaseItem
import kotli.app.feature.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object GeminiShowcase : kotli.app.feature.showcases.ShowcaseItem {

    override val label: String = "Gemini AI"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(GeminiDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        GeminiDestination
    )

}