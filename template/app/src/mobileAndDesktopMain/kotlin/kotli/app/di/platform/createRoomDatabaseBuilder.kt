package kotli.app.di.platform

import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import kotli.app.common.data.source.database.room.AppDatabase

expect fun createRoomDatabaseBuilder(name: String): RoomDatabase.Builder<AppDatabase>

expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase>