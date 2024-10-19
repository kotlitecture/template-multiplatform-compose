package kotli.app.koin.feature

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotli.app.AppMutableState
import kotli.app.AppState
import kotli.app.AppViewModel
import kotli.app.common.presentation.loader.LoaderViewModel
import kotli.app.common.presentation.navigation.NavigationMutableState
import kotli.app.feature.a.presentation.AViewModel
import kotli.app.feature.b.presentation.BViewModel
import kotli.app.feature.c.presentation.CViewModel
import kotli.app.feature.passcode.presentation.forgot.ForgotPasscodeViewModel
import kotli.app.feature.passcode.presentation.provide.PasscodeViewModel
import kotli.app.feature.passcode.presentation.reset.ResetPasscodeViewModel
import kotli.app.feature.passcode.presentation.set.SetPasscodeViewModel
import kotli.app.feature.passcode.presentation.unlock.UnlockPasscodeViewModel
import kotli.app.feature.showcases.presentation.ShowcasesViewModel
import kotli.app.feature.showcases.presentation.dataflow.ai.gemini.GeminiViewModel
import kotli.app.feature.showcases.presentation.dataflow.cache.basic.BasicCacheViewModel
import kotli.app.feature.showcases.presentation.dataflow.encryption.BasicEncryptionViewModel
import kotli.app.feature.showcases.presentation.dataflow.http.basic.BasicHttpViewModel
import kotli.app.feature.showcases.presentation.dataflow.keyvalue.`object`.ObjectKeyValueViewModel
import kotli.app.feature.showcases.presentation.dataflow.keyvalue.primitive.PrimitiveKeyValueViewModel
import kotli.app.feature.showcases.presentation.dataflow.paging.basic.BasicPagingViewModel
import kotli.app.feature.showcases.presentation.dataflow.sqldelight.crud.SqlDelightCrudViewModel
import kotli.app.feature.showcases.presentation.dataflow.sqldelight.paging.SqlDelightPagingViewModel
import kotli.app.feature.showcases.presentation.userflow.component.filepicker.FilePickerViewModel
import kotli.app.feature.showcases.presentation.userflow.component.placeholder.PlaceholderViewModel
import kotli.app.feature.theme.change.presentation.ChangeThemeViewModel
import kotli.app.feature.theme.provide.presentation.ThemePersistenceViewModel
import kotli.app.feature.theme.provide.presentation.ThemeViewModel
import kotli.app.feature.theme.toggle.presentation.ToggleThemeViewModel
import kotli.app.koin.platform.createRoomCrudViewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import shared.design.component.AppSnackbarState
import kotli.app.feature.showcases.presentation.userflow.loader.LoaderViewModel as ShowcaseLoaderViewModel

val appModule = module {
    single { AppSnackbarState() }
    single { NavigationMutableState() }
    single { AppMutableState(get(), get()) }.bind(AppState::class)
    single {
        viewModelFactory {
            initializer { AViewModel() }
            initializer { BViewModel() }
            initializer { CViewModel() }
            initializer { AppViewModel(get()) }
            initializer { ThemeViewModel(get()) }
            initializer { ThemePersistenceViewModel(get(), get(), get()) }
            initializer { ShowcasesViewModel() }
            initializer { ChangeThemeViewModel(get()) }
            initializer { ToggleThemeViewModel(get()) }
            initializer { BasicPagingViewModel(get()) }
            initializer { BasicHttpViewModel(get()) }
            initializer { LoaderViewModel(get()) }
            initializer { ShowcaseLoaderViewModel() }
            initializer { PrimitiveKeyValueViewModel(get()) }
            initializer { ObjectKeyValueViewModel(get()) }
            initializer { SqlDelightCrudViewModel(get()) }
            initializer { SqlDelightPagingViewModel(get(), get(), get()) }
            initializer { BasicCacheViewModel(get()) }
            initializer { PlaceholderViewModel() }
            initializer { BasicEncryptionViewModel(get()) }
            initializer { PasscodeViewModel(get(), get()) }
            initializer { SetPasscodeViewModel(get(), get(), get(), get(), get()) }
            initializer { ResetPasscodeViewModel(get(), get(), get(), get()) }
            initializer { UnlockPasscodeViewModel(get(), get(), get()) }
            initializer { ForgotPasscodeViewModel(get()) }
            initializer { FilePickerViewModel() }
            initializer { GeminiViewModel(get()) }
            initializer { createRoomCrudViewModel() }
        }
    }
}