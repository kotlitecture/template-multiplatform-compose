package kotli.app.feature.showcases.presentation.dataflow.sqldelight.paging

import androidx.lifecycle.viewModelScope
import app.cash.paging.PagingData
import app.cash.paging.cachedIn
import app.cash.sqldelight.async.coroutines.awaitAsOne
import kotli.app.common.data.source.database.sqldelight.AppSqlDelightSource
import kotli.app.common.data.source.database.sqldelight.User
import kotli.app.common.data.source.paging.AppPagingSource
import kotlinx.coroutines.flow.Flow
import shared.design.component.AppSnackbarState
import shared.presentation.viewmodel.BaseViewModel

class SqlDelightPagingViewModel(
    private val appSnackbarStore: AppSnackbarState,
    private val databaseSource: AppSqlDelightSource,
    private val pagingSource: AppPagingSource,
) : BaseViewModel() {

    private var pagingSourceRef: SqlDelightPagingSource? = null

    val state: SqlDelightPagingState by lazy {
        val pager = pagingSource.getPager {
            SqlDelightPagingSource(databaseSource).also { source ->
                pagingSourceRef = source
            }
        }
        val flow = pager.flow.cachedIn(viewModelScope)
        SqlDelightPagingMutableState(flow)
    }

    override fun doBind() = async("Init users") {
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

    fun onDelete(user: User) = async("Delete user ${user.id}") {
        val database = databaseSource.getDatabase()
        database.userQueries.delete(user.id)
        showToast("User ${user.lastName} deleted")
        refreshUsers()
    }

    private fun refreshUsers() {
        pagingSourceRef?.invalidate()
    }

    private fun showToast(message: String) = async("Show toast", force = true) {
        appSnackbarStore.showSnackbar(message)
    }

    private class SqlDelightPagingMutableState(
        override val users: Flow<PagingData<User>>
    ) : SqlDelightPagingState
}
