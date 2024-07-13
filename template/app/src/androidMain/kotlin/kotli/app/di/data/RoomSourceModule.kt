package kotli.app.di.data

import kotli.app.data.source.database.room.AppRoomSource
import org.koin.dsl.module

val roomSourceModule = module {
    single { AppRoomSource() }
}