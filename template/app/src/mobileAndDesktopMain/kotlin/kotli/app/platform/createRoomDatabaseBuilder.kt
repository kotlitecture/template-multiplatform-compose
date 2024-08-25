package kotli.app.platform

import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import kotli.app.data.source.database.room.AppDatabase

expect fun createRoomDatabaseBuilder(name: String): RoomDatabase.Builder<AppDatabase>

expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase>