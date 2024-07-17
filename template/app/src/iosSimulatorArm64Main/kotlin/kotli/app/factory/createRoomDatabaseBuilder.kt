package kotli.app.factory

import androidx.room.Room
import androidx.room.RoomDatabase
import kotli.app.data.source.database.room.AppDatabase
import kotli.app.data.source.database.room.instantiateImpl
import platform.Foundation.NSHomeDirectory

actual fun createRoomDatabaseBuilder(name: String): RoomDatabase.Builder<AppDatabase> {
    val dbFilePath = NSHomeDirectory() + "/$name"
    return Room.databaseBuilder<AppDatabase>(
        name = dbFilePath,
        factory = { AppDatabase::class.instantiateImpl() }
    )
}