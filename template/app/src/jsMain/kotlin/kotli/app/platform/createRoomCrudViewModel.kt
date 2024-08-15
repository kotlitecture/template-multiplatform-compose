package kotli.app.platform

import kotli.app.di.get
import kotli.app.presentation.showcases.dataflow.room.crud.RoomCrudViewModel
import kotli.app.presentation.showcases.dataflow.room.crud.model.UserData
import shared.design.component.AppSnackbarStore
import shared.presentation.navigation.NavigationStore

actual fun createRoomCrudViewModel(): RoomCrudViewModel = RoomCrudViewModelImpl(
    snackbarStore = get(),
    navigationStore = get()
)

private class RoomCrudViewModelImpl(
    private val snackbarStore: AppSnackbarStore,
    navigationStore: NavigationStore
) : RoomCrudViewModel(
    navigationStore
) {
    override fun onAdd() = launchAsync {
        snackbarStore.showSnackbar("Room is not supported for the Web target")
    }

    override fun onDelete(user: UserData) = launchAsync {
        snackbarStore.showSnackbar("Room is not supported for the Web target")
    }

}