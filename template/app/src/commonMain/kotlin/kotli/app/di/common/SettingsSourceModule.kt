package kotli.app.di.common

import org.koin.dsl.module
import shared.data.source.settings.SettingsSource
import shared.data.source.settings.BasicSettingsSource

val settingsSourceModule = module {
    single<SettingsSource> { BasicSettingsSource() }
}