package kotli.app.showcases.presentation.dataflow.sqldelight.crud

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotli.app.common.data.source.database.DatabaseSource
import kotli.app.common.data.source.database.UserEntity
import kotlinx.coroutines.flow.collectLatest
import shared.presentation.viewmodel.BaseViewModel

class SqlDelightCrudViewModel(
    private val databaseSource: DatabaseSource
) : BaseViewModel() {

    private val _state = SqlDelightCrudMutableState()
    val state: SqlDelightCrudState = _state

    override fun doBind() = async("Monitor users") {
        databaseSource.getUsersLive().collectLatest(_state::users::set)
    }

    fun onAdd() = async("Add new user") {
        val count = databaseSource.getUsersCount() + 1
        val firstName = "first_name_$count"
        val lastName = "last_name_$count"
        databaseSource.insertUser(firstName, lastName)
    }

    fun onDelete(user: UserEntity) = async("Delete user ${user.id}") {
        databaseSource.deleteUser(user.id)
    }

    private class SqlDelightCrudMutableState : SqlDelightCrudState {
        override var users: List<UserEntity> by mutableStateOf(emptyList())
    }
}
