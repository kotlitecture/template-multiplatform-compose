package kotli.app.feature.showcases.presentation.dataflow.sqldelight.crud

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import app.cash.sqldelight.async.coroutines.awaitAsList
import app.cash.sqldelight.async.coroutines.awaitAsOne
import app.cash.sqldelight.coroutines.asFlow
import kotli.app.common.data.source.database.sqldelight.AppSqlDelightSource
import kotli.app.common.data.source.database.sqldelight.User
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import shared.presentation.viewmodel.BaseViewModel

class SqlDelightCrudViewModel(
    private val databaseSource: AppSqlDelightSource
) : BaseViewModel() {

    private val _state = SqlDelightCrudMutableState()
    val state: SqlDelightCrudState = _state

    override fun doBind() = async("Monitor users") {
        val database = databaseSource.getDatabase()
        database.userQueries.getAll().asFlow()
            .map { query -> query.awaitAsList() }
            .collectLatest(_state::users::set)
    }

    fun onAdd() = async("Add new user") {
        val database = databaseSource.getDatabase()
        val count = database.userQueries.count().awaitAsOne() + 1
        val firstName = "first_name_$count"
        val lastName = "last_name_$count"
        database.userQueries.insert(firstName, lastName)
    }

    fun onDelete(user: User) = async("Delete user ${user.id}") {
        val database = databaseSource.getDatabase()
        database.userQueries.delete(user.id)
    }

    private class SqlDelightCrudMutableState : SqlDelightCrudState {
        override var users: List<User> by mutableStateOf(emptyList())
    }
}
