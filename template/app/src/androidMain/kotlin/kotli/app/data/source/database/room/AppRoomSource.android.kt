package kotli.app.data.source.database.room

import androidx.room.Room
import androidx.room.RoomDatabase
import kotli.app.Application

actual fun getRoomDatabaseBuilder(name: String): RoomDatabase.Builder<AppDatabase> {
    val context = Application.instance
    val dbFile = context.getDatabasePath(name)
    return Room.databaseBuilder<AppDatabase>(
        context = context,
        name = dbFile.absolutePath
    )
}