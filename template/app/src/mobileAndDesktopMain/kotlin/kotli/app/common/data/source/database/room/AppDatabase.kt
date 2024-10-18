package kotli.app.common.data.source.database.room

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kotli.app.common.data.source.database.room.dao.UserDao
import kotli.app.common.data.source.database.room.entity.User
import kotli.app.koin.platform.AppDatabaseConstructor

/**
 * This class represents the Room database for the application.
 */
@Database(
    entities = [
        User::class
    ],
    version = 1
)
@TypeConverters(Converters::class)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {

    /**
     * Retrieves the DAO (Data Access Object) for interacting with the User entity.
     *
     * @return The UserDao instance.
     */
    abstract fun getUserDao(): UserDao

}