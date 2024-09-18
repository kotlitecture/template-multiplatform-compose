package kotli.app.presentation.showcases.userflow.component.filepicker

import kotli.app.presentation.showcases.ShowcaseItem
import kotli.app.presentation.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object FilePickerShowcase : ShowcaseItem {

    override val label: String = "File Picker"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(FilePickerShowcaseDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        FilePickerShowcaseDestination
    )

}