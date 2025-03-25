package kotli.app.common.data.source.database.room

import androidx.room.RoomDatabase
import androidx.room.useWriterConnection
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotli.app.common.data.source.database.DatabaseSource
import kotli.app.common.data.source.database.UserEntity
import kotli.app.common.data.source.database.room.entity.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * This class represents a source for accessing the Room database.
 *
 * It provides access to all underlying DAO objects as well.
 */
class RoomSource(
    private val databaseBuilder: RoomDatabase.Builder<AppDatabase>,
) : DatabaseSource {

    private val db by lazy {
        databaseBuilder
            .fallbackToDestructiveMigrationOnDowngrade(false)
            .setDriver(BundledSQLiteDriver())
            .build()
    }

    private val userDao by lazy { db.getUserDao() }

    override suspend fun getUsersLive(): Flow<List<UserEntity>> {
        return userDao.getAllAsFlow().map { all -> all.map(::map) }
    }

    override suspend fun getUsers(limit: Int, offset: Int): List<UserEntity> {
        return userDao.getAll(limit, offset).map(::map)
    }

    override suspend fun insertUser(firstName: String, lastName: String) {
        userDao.create(User(firstName = firstName, lastName = lastName))
    }

    override suspend fun deleteUser(id: Long) {
        userDao.delete(User(id = id))
    }

    override suspend fun getUsersCount(): Long {
        return userDao.count()
    }

    override suspend fun inTx(block: suspend () -> Unit) {
        db.useWriterConnection { block() }
    }

    private fun map(from: User): UserEntity {
        return UserEntity(
            id = from.id,
            firstName = from.firstName,
            lastName = from.lastName
        )
    }
}