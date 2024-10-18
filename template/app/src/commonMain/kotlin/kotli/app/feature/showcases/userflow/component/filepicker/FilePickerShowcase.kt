package kotli.app.feature.showcases.userflow.component.filepicker

import kotli.app.feature.showcases.ShowcaseItem
import kotli.app.feature.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object FilePickerShowcase : kotli.app.feature.showcases.ShowcaseItem {

    override val label: String = "File Picker"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(FilePickerShowcaseDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        FilePickerShowcaseDestination
    )

}