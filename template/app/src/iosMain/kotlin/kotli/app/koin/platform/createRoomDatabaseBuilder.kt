package kotli.app.koin.platform

import androidx.room.Room
import androidx.room.RoomDatabase
import kotli.app.common.data.source.database.room.AppDatabase
import platform.Foundation.NSHomeDirectory

actual fun createRoomDatabaseBuilder(name: String): RoomDatabase.Builder<AppDatabase> {
    val dbFilePath = NSHomeDirectory() + "/$name"
    return Room.databaseBuilder<AppDatabase>(
        name = dbFilePath
    )
}