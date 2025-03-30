package kotli.app.common.data.source.database

import kotlinx.coroutines.flow.Flow
import shared.data.source.DataSource

interface DatabaseSource : DataSource {

    suspend fun inTx(block: suspend () -> Unit)

    suspend fun getUsersCount(): Long
    suspend fun getUsersLive(): Flow<List<UserEntity>>
    suspend fun getUsers(limit: Int, offset: Int): List<UserEntity>
    suspend fun insertUser(firstName: String, lastName: String)
    suspend fun deleteUser(id: Long)
}