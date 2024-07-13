package kotli.app.presentation.showcases.dataflow.room.crud

import kotli.app.presentation.showcases.ShowcaseItem
import kotli.app.presentation.showcases.ShowcasesViewModel
import shared.presentation.navigation.NavigationDestination

object RoomCrudShowcase : ShowcaseItem {

    override val label: String = "Room CRUD"

    override fun onClick(viewModel: ShowcasesViewModel) {
        viewModel.navigationStore.onNext(RoomCrudDestination)
    }

    override fun dependsOn(): List<NavigationDestination<*>> = listOf(
        RoomCrudDestination
    )

}