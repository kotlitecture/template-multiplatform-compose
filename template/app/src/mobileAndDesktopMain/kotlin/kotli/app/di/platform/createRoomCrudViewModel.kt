package kotli.app.di.platform

import kotli.app.common.data.source.database.room.AppRoomSource
import kotli.app.common.data.source.database.room.entity.User
import kotli.app.feature.showcases.presentation.dataflow.room.crud.RoomCrudViewModel
import kotli.app.feature.showcases.presentation.dataflow.room.crud.UserData
import kotli.app.di.inject
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map

actual fun createRoomCrudViewModel(): RoomCrudViewModel = RoomCrudViewModelImpl(
    roomSource = inject()
)

private class RoomCrudViewModelImpl(
    private val roomSource: AppRoomSource
) : RoomCrudViewModel() {

    override fun doBind() = async("Get available users") {
        roomSource.userDao
            .getAllAsFlow().map { users ->
                users.map { user ->
                    UserData(user.id, user.firstName, user.lastName)
                }
            }
            .collectLatest(_state::users::set)
    }

    override fun onAdd() = async("Add new user") {
        val dao = roomSource.userDao
        val count = dao.count() + 1
        val firstName = "first_name_$count"
        val lastName = "last_name_$count"
        dao.create(User(firstName = firstName, lastName = lastName))
    }

    override fun onDelete(user: UserData) = async("Delete user ${user.id}") {
        val dao = roomSource.userDao
        dao.delete(User(user.id))
    }

}