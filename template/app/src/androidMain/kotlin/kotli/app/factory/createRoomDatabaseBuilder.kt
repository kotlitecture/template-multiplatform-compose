package kotli.app.factory

import androidx.room.Room
import androidx.room.RoomDatabase
import kotli.app.Application
import kotli.app.data.source.database.room.AppDatabase

actual fun createRoomDatabaseBuilder(name: String): RoomDatabase.Builder<AppDatabase> {
    val context = Application.instance
    val dbFile = context.getDatabasePath(name)
    return Room.databaseBuilder<AppDatabase>(
        context = context,
        name = dbFile.absolutePath
    )
}