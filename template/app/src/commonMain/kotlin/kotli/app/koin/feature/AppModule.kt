package kotli.app.koin.feature

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotli.app.AppViewModel
import kotli.app.common.presentation.loader.LoaderViewModel
import kotli.app.feature.a.presentation.AViewModel
import kotli.app.feature.b.presentation.BViewModel
import kotli.app.feature.c.presentation.CViewModel
import kotli.app.feature.passcode.provide.presentation.PasscodeViewModel
import kotli.app.feature.passcode.forgot.presentation.ForgotPasscodeViewModel
import kotli.app.feature.passcode.reset.presentation.ResetPasscodeViewModel
import kotli.app.feature.passcode.set.presentation.SetPasscodeViewModel
import kotli.app.feature.passcode.unlock.presentation.UnlockPasscodeViewModel
import kotli.app.feature.showcases.ShowcasesViewModel
import kotli.app.feature.showcases.dataflow.ai.gemini.GeminiViewModel
import kotli.app.feature.showcases.dataflow.cache.basic.BasicCacheViewModel
import kotli.app.feature.showcases.dataflow.encryption.BasicEncryptionViewModel
import kotli.app.feature.showcases.dataflow.http.basic.BasicHttpViewModel
import kotli.app.feature.showcases.dataflow.keyvalue.`object`.ObjectKeyValueViewModel
import kotli.app.feature.showcases.dataflow.keyvalue.primitive.PrimitiveKeyValueViewModel
import kotli.app.feature.showcases.dataflow.paging.basic.BasicPagingViewModel
import kotli.app.feature.showcases.dataflow.sqldelight.crud.SqlDelightCrudViewModel
import kotli.app.feature.showcases.dataflow.sqldelight.paging.SqlDelightPagingViewModel
import kotli.app.feature.showcases.userflow.component.filepicker.FilePickerShowcaseViewModel
import kotli.app.feature.showcases.userflow.component.image.coil.CoilShowcaseViewModel
import kotli.app.feature.showcases.userflow.component.markdown.MarkdownShowcaseViewModel
import kotli.app.feature.showcases.userflow.component.placeholder.PlaceholderShowcaseViewModel
import kotli.app.feature.showcases.userflow.loader.data.DataLoaderShowcaseViewModel
import kotli.app.feature.showcases.userflow.navigation.args.from.ArgsNavigationFromViewModel
import kotli.app.feature.showcases.userflow.navigation.args.to.ArgsNavigationToViewModel
import kotli.app.feature.showcases.userflow.navigation.no_args.from.NoArgsNavigationFromViewModel
import kotli.app.feature.showcases.userflow.navigation.no_args.to.NoArgsNavigationToViewModel
import kotli.app.feature.theme.change.presentation.ChangeThemeViewModel
import kotli.app.feature.theme.provide.presentation.ThemePersistenceViewModel
import kotli.app.feature.theme.provide.presentation.ThemeViewModel
import kotli.app.feature.theme.toggle.presentation.ToggleThemeViewModel
import kotli.app.koin.platform.createRoomCrudViewModel
import org.koin.dsl.module
import shared.design.component.AppSnackbarState
import shared.presentation.navigation.NavigationStore

val appModule = module {
    single { AppSnackbarState() }
    single { NavigationStore(emptyList()) }
    single {
        viewModelFactory {
            initializer { AViewModel() }
            initializer { BViewModel() }
            initializer { CViewModel() }
            initializer { ShowcasesViewModel(get()) }
            initializer { AppViewModel(get()) }
            initializer { ThemeViewModel(get()) }
            initializer { ThemePersistenceViewModel(get(), get(), get()) }
            initializer { ChangeThemeViewModel(get(), get()) }
            initializer { ToggleThemeViewModel(get()) }
            initializer { BasicPagingViewModel(get(), get()) }
            initializer { BasicHttpViewModel(get(), get()) }
            initializer { NoArgsNavigationFromViewModel(get()) }
            initializer { NoArgsNavigationToViewModel(get()) }
            initializer { ArgsNavigationFromViewModel(get()) }
            initializer { ArgsNavigationToViewModel(get()) }
            initializer { LoaderViewModel(get()) }
            initializer { DataLoaderShowcaseViewModel(get()) }
            initializer { PrimitiveKeyValueViewModel(get(), get()) }
            initializer { ObjectKeyValueViewModel(get(), get()) }
            initializer { SqlDelightCrudViewModel(get(), get()) }
            initializer { SqlDelightPagingViewModel(get(), get(), get(), get()) }
            initializer { BasicCacheViewModel(get(), get()) }
            initializer { PlaceholderShowcaseViewModel(get()) }
            initializer { BasicEncryptionViewModel(get(), get()) }
            initializer { PasscodeViewModel(get(), get()) }
            initializer { CoilShowcaseViewModel(get()) }
            initializer { SetPasscodeViewModel(get(), get(), get(), get(), get()) }
            initializer { ResetPasscodeViewModel(get(), get(), get(), get()) }
            initializer { UnlockPasscodeViewModel(get(), get(), get()) }
            initializer { ForgotPasscodeViewModel(get()) }
            initializer { MarkdownShowcaseViewModel(get()) }
            initializer { FilePickerShowcaseViewModel(get()) }
            initializer { GeminiViewModel(get(), get()) }
            initializer { createRoomCrudViewModel() }
        }
    }
}