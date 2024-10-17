package kotli.app.platform

import kotli.app.di.get
import kotli.app.presentation.showcases.dataflow.room.crud.RoomCrudViewModel
import kotli.app.presentation.showcases.dataflow.room.crud.model.UserData
import shared.design.component.AppSnackbarState
import shared.presentation.navigation.NavigationStore

actual fun createRoomCrudViewModel(): RoomCrudViewModel = RoomCrudViewModelImpl(
    snackbarStore = get(),
    navigationStore = get()
)

private class RoomCrudViewModelImpl(
    private val snackbarStore: AppSnackbarState,
    navigationStore: NavigationStore
) : RoomCrudViewModel(
    navigationStore
) {
    override fun onAdd() = async("Add new user") {
        snackbarStore.showSnackbar("Room is not supported for the Web target")
    }

    override fun onDelete(user: UserData) = async("Delete user ${user.id}") {
        snackbarStore.showSnackbar("Room is not supported for the Web target")
    }

}