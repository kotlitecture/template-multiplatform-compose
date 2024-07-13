package kotli.app.data.source.database.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotli.app.data.source.database.room.entity.User
import kotlinx.coroutines.flow.Flow

/**
 * Represents a DAO (Data Access Object) for interacting with the [User] domain.
 *
 * This interface serves as an example of a typical DAO.
 *
 * For more information on the anatomy of a DAO, refer to:
 * [https://developer.android.com/training/data-storage/room/accessing-data#kotlin]
 */
@Dao
interface UserDao {

    @Insert
    suspend fun create(user: User): Long

    @Update
    suspend fun update(vararg users: User)

    @Delete
    suspend fun delete(vararg user: User)

    @Query("SELECT * FROM user WHERE id = :id LIMIT 1")
    suspend fun get(id: Long): User?

    @Query("SELECT * FROM user")
    suspend fun getAll(): List<User>

    @Query("SELECT * FROM user")
    fun getAllAsFlow(): Flow<List<User>>

    @Query("SELECT COUNT(*) FROM user")
    suspend fun count(): Long

}