package kotli.app.presentation.showcases.dataflow.room.crud

import kotli.app.data.source.database.room.AppRoomSource
import kotli.app.data.source.database.room.entity.User
import kotli.app.di.get
import kotli.app.presentation.showcases.dataflow.room.crud.model.UserData
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import shared.presentation.navigation.NavigationStore

actual fun createRoomCrudViewModel(): RoomCrudViewModel = RoomCrudViewModelImpl(
    navigationStore = get(),
    roomSource = get()
)

private class RoomCrudViewModelImpl(
    navigationStore: NavigationStore,
    private val roomSource: AppRoomSource
) : RoomCrudViewModel(navigationStore) {

    override fun doBind() {
        launchAsync("getUsers") {
            roomSource.userDao
                .getAllAsFlow().map { users ->
                    users.map { user ->
                        UserData(user.id, user.firstName, user.lastName)
                    }
                }
                .collectLatest(usersState::set)
        }
    }

    override fun onAdd() = launchAsync {
        val dao = roomSource.userDao
        val count = dao.count() + 1
        val firstName = "first_name_$count"
        val lastName = "last_name_$count"
        dao.create(User(firstName = firstName, lastName = lastName))
    }

    override fun onDelete(user: UserData) = launchAsync {
        val dao = roomSource.userDao
        dao.delete(User(user.id))
    }

}