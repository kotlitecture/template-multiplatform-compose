package kotli.app.feature.showcases.presentation.dataflow.room.crud

import kotli.app.feature.showcases.presentation.ShowcasesViewModel
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