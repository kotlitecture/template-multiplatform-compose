package kotli.app.showcases.datasource.sqldelight.paging

import androidx.lifecycle.viewModelScope
import app.cash.paging.cachedIn
import app.cash.sqldelight.async.coroutines.awaitAsOne
import kotli.app.data.source.database.sqldelight.AppSqlDelightSource
import kotli.app.data.source.database.sqldelight.User
import kotli.app.data.source.paging.AppPagingSource
import shared.design.component.AppSnackbarStore
import shared.presentation.viewmodel.BaseViewModel
import shared.presentation.navigation.NavigationStore

class SqlDelightPagingViewModel(
    private val appSnackbarStore: AppSnackbarStore,
    private val navigationStore: NavigationStore,
    private val databaseSource: AppSqlDelightSource,
    private val pagingSource: AppPagingSource,
) : BaseViewModel() {

    private var pagingSourceRef: SqlDelightPagingSource? = null

    val usersFlow by lazy {
        val pager = pagingSource.getPager {
            SqlDelightPagingSource(databaseSource).also { source ->
                pagingSourceRef = source
            }
        }
        pager.flow.cachedIn(viewModelScope)
    }

    fun onBack() {
        navigationStore.onBack()
    }

    override fun doBind() {
        launchAsync("fillUsers") { fillUsers() }
    }

    fun onDelete(user: User) = launchAsync {
        val database = databaseSource.getDatabase()
        database.userQueries.delete(user.id)
        showToast("User ${user.lastName} deleted")
        refreshUsers()
    }

    private suspend fun fillUsers() {
        val max = 100
        val database = databaseSource.getDatabase()
        val userQueries = database.userQueries
        val count = userQueries.count().awaitAsOne()
        if (count < max) {
            database.transaction {
                (count until max).forEach { id ->
                    val uid = id + 1
                    val firstName = "first_name_$uid"
                    val lastName = "last_name_$uid"
                    userQueries.insert(firstName, lastName)
                }
            }
            showToast("Added ${max - count} users")
            refreshUsers()
        }
    }

    private fun refreshUsers() {
        pagingSourceRef?.invalidate()
    }

    private fun showToast(message: String) {
        launchAsync("showToast") {
            appSnackbarStore.showSnackbar(message)
        }
    }
}
