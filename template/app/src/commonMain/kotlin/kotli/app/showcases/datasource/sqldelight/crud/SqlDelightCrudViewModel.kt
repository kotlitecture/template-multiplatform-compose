package kotli.app.showcases.datasource.sqldelight.crud

import app.cash.sqldelight.async.coroutines.awaitAsList
import app.cash.sqldelight.async.coroutines.awaitAsOne
import app.cash.sqldelight.coroutines.asFlow
import kotli.app.data.source.database.sqldelight.AppSqlDelightSource
import kotli.app.data.source.database.sqldelight.User
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationStore
import shared.presentation.store.DataState

class SqlDelightCrudViewModel(
    private val navigationStore: NavigationStore,
    private val databaseSource: AppSqlDelightSource
) : BaseViewModel() {

    val usersState = DataState<List<User>>(emptyList())

    override fun doBind() {
        launchAsync("getUsers") {
            val database = databaseSource.getDatabase()
            database.userQueries.getAll().asFlow()
                .map { query -> query.awaitAsList() }
                .collectLatest(usersState::set)
        }
    }

    fun onBack() {
        navigationStore.onBack()
    }

    fun onAdd() = launchAsync {
        val database = databaseSource.getDatabase()
        val count = database.userQueries.count().awaitAsOne() + 1
        val firstName = "first_name_$count"
        val lastName = "last_name_$count"
        database.userQueries.insert(firstName, lastName)
    }

    fun onDelete(user: User) = launchAsync {
        val database = databaseSource.getDatabase()
        database.userQueries.delete(user.id)
    }
}
