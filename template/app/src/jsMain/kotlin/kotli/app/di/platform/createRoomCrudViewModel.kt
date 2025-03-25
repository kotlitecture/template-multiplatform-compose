package kotli.app.di.platform

import kotli.app.showcases.presentation.dataflow.room.crud.RoomCrudViewModel
import kotli.app.showcases.presentation.dataflow.room.crud.UserData
import kotli.app.get
import shared.design.component.AppSnackbarState

actual fun createRoomCrudViewModel(): RoomCrudViewModel = RoomCrudViewModelImpl(
    snackbarStore = get()
)

private class RoomCrudViewModelImpl(
    private val snackbarStore: AppSnackbarState
) : RoomCrudViewModel() {

    override fun onAdd() = async("Add new user") {
        snackbarStore.showSnackbar("Room is not supported for the Web target")
    }

    override fun onDelete(user: UserData) = async("Delete user ${user.id}") {
        snackbarStore.showSnackbar("Room is not supported for the Web target")
    }

}