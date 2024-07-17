package kotli.app.factory

import androidx.room.RoomDatabase
import kotli.app.data.source.database.room.AppDatabase

expect fun createRoomDatabaseBuilder(name: String): RoomDatabase.Builder<AppDatabase>