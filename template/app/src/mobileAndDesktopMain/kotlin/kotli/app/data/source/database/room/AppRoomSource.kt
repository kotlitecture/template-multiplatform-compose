package kotli.app.data.source.database.room

import androidx.room.RoomDatabase
import androidx.room.useWriterConnection
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

/**
 * This class represents a source for accessing the Room database.
 *
 * It provides access to all underlying DAO objects as well.
 *
 * @property databaseName The name of the database.
 */
class AppRoomSource(
    private val databaseName: String = "room.db"
) {

    private val db by lazy {
        getRoomDatabaseBuilder(databaseName)
            .fallbackToDestructiveMigrationOnDowngrade(false)
            .setDriver(BundledSQLiteDriver())
            .build()
    }

    /**
     * Retrieves the UserDao for interacting with the User entity.
     *
     * @return The UserDao instance.
     */
    val userDao by lazy { db.getUserDao() }

    /**
     * Executes a transaction on the database.
     *
     * @param <R> The type of the result.
     * @param block The block of code to execute within the transaction.
     * @return The result of the transaction.
     */
    suspend fun <R> withTransaction(block: suspend () -> R): R = db.useWriterConnection { block() }

}

expect fun getRoomDatabaseBuilder(name: String): RoomDatabase.Builder<AppDatabase>