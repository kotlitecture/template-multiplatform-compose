package kotli.app.showcases.datasource.sqldelight.crud

import app.cash.sqldelight.async.coroutines.awaitAsList
import app.cash.sqldelight.coroutines.asFlow
import kotli.app.datasource.database.sqldelight.AppSqlDelightSource
import kotli.app.datasource.database.sqldelight.User
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import shared.presentation.BaseViewModel
import shared.presentation.navigation.NavigationState
import shared.presentation.state.StoreObject

class SqlDelightCrudViewModel(
    private val navigationState: NavigationState,
    private val databaseSource: AppSqlDelightSource
) : BaseViewModel() {

    val usersStore = StoreObject<List<User>>(emptyList())

    override fun doBind() {
        launchAsync("getUsers") {
            val database = databaseSource.getDatabase()
            database.userQueries.getAll().asFlow()
                .map { query -> query.awaitAsList() }
                .collectLatest(usersStore::set)
        }
    }

    fun onBack() {
        navigationState.onBack()
    }

    fun onAdd() = launchAsync {
        val database = databaseSource.getDatabase()
        val count = database.userQueries.count().executeAsOne() + 1
        val firstName = "first_name_$count"
        val lastName = "last_name_$count"
        database.userQueries.insert(firstName, lastName)
    }

    fun onDelete(user: User) = launchAsync {
        val database = databaseSource.getDatabase()
        database.userQueries.delete(user.id)
    }
}
