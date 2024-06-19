package kotli.app.showcases.datasource.sqlight.crud

import app.cash.sqldelight.async.coroutines.awaitAsList
import app.cash.sqldelight.coroutines.asFlow
import kotli.app.datasource.database.sqldelight.AppSqlDelightSource
import kotli.app.datasource.database.sqldelight.User
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import shared.presentation.BaseViewModel
import shared.presentation.navigation.NavigationState
import shared.presentation.state.StoreObject

class SqlDelightCrudViewModel(
    private val navigationState: NavigationState,
    private val databaseSource: AppSqlDelightSource
) : BaseViewModel() {

    val usersStore = StoreObject<List<User>>()

    override fun doBind() {
        launchAsync("getUsers") {
            val database = databaseSource.getDatabase()
            database.userQueries.getAll().asFlow()
                .map { query -> query.awaitAsList() }
                .onEach { println("USERS :: ${it.size}") }
                .collectLatest(usersStore::set)
        }
    }

    fun onBack() {
        navigationState.onBack()
    }

    fun onAdd() = launchAsync {
        val user = User(
            id = 0L,
            firstName = "first_name",
            lastName = "last_name"
        )
        val database = databaseSource.getDatabase()
        database.userQueries.insert(user.firstName, user.lastName)
    }

    fun onDelete(user: User) = launchAsync {
        val database = databaseSource.getDatabase()
        database.userQueries.delete(user.id)
    }
}
