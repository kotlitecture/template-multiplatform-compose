package kotli.app.factory

import androidx.room.Room
import androidx.room.RoomDatabase
import kotli.app.data.source.database.room.AppDatabase
import java.io.File

actual fun createRoomDatabaseBuilder(name: String): RoomDatabase.Builder<AppDatabase> {
    val dbFile = File(System.getProperty("java.io.tmpdir"), name)
    return Room.databaseBuilder<AppDatabase>(
        name = dbFile.absolutePath,
    )
}