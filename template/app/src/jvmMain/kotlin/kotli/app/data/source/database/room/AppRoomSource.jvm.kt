package kotli.app.data.source.database.room

import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.File

actual fun getRoomDatabaseBuilder(name: String): RoomDatabase.Builder<AppDatabase> {
    val dbFile = File(System.getProperty("java.io.tmpdir"), name)
    return Room.databaseBuilder<AppDatabase>(
        name = dbFile.absolutePath,
    )
}