package kotli.app.di.feature

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotli.app.AppViewModel
import kotli.app.common.presentation.loader.LoaderViewModel
import kotli.app.common.presentation.navigation.samples.a.NavigationAViewModel
import kotli.app.common.presentation.navigation.samples.b.NavigationBViewModel
import kotli.app.common.presentation.navigation.samples.c.NavigationCViewModel
import kotli.app.platform.createRoomCrudViewModel
import kotli.app.presentation.passcode.PasscodeViewModel
import kotli.app.presentation.passcode.ui.forgot.ForgotPasscodeViewModel
import kotli.app.presentation.passcode.ui.reset.ResetPasscodeViewModel
import kotli.app.presentation.passcode.ui.set.SetPasscodeViewModel
import kotli.app.presentation.passcode.ui.unlock.UnlockPasscodeViewModel
import kotli.app.presentation.showcases.ShowcasesViewModel
import kotli.app.presentation.showcases.dataflow.ai.gemini.GeminiViewModel
import kotli.app.presentation.showcases.dataflow.cache.basic.BasicCacheViewModel
import kotli.app.presentation.showcases.dataflow.encryption.BasicEncryptionViewModel
import kotli.app.presentation.showcases.dataflow.http.basic.BasicHttpViewModel
import kotli.app.presentation.showcases.dataflow.keyvalue.`object`.ObjectKeyValueViewModel
import kotli.app.presentation.showcases.dataflow.keyvalue.primitive.PrimitiveKeyValueViewModel
import kotli.app.presentation.showcases.dataflow.paging.basic.BasicPagingViewModel
import kotli.app.presentation.showcases.dataflow.sqldelight.crud.SqlDelightCrudViewModel
import kotli.app.presentation.showcases.dataflow.sqldelight.paging.SqlDelightPagingViewModel
import kotli.app.presentation.showcases.userflow.component.filepicker.FilePickerShowcaseViewModel
import kotli.app.presentation.showcases.userflow.component.image.coil.CoilShowcaseViewModel
import kotli.app.presentation.showcases.userflow.component.markdown.MarkdownShowcaseViewModel
import kotli.app.presentation.showcases.userflow.component.placeholder.PlaceholderShowcaseViewModel
import kotli.app.presentation.showcases.userflow.loader.data.DataLoaderShowcaseViewModel
import kotli.app.presentation.showcases.userflow.navigation.args.from.ArgsNavigationFromViewModel
import kotli.app.presentation.showcases.userflow.navigation.args.to.ArgsNavigationToViewModel
import kotli.app.presentation.showcases.userflow.navigation.no_args.from.NoArgsNavigationFromViewModel
import kotli.app.presentation.showcases.userflow.navigation.no_args.to.NoArgsNavigationToViewModel
import kotli.app.presentation.template.screen_with_args.TemplateViewModel
import kotli.app.presentation.template.screen_without_args.TemplateNoArgsViewModel
import kotli.app.theme.change.presentation.ChangeThemeViewModel
import kotli.app.theme.provide.presentation.AppThemePersistenceViewModel
import kotli.app.theme.provide.presentation.AppThemeViewModel
import kotli.app.theme.toggle.presentation.ToggleThemeViewModel
import org.koin.dsl.module
import shared.design.component.AppSnackbarState
import shared.presentation.navigation.NavigationStore

val appModule = module {
    single { AppSnackbarState() }
    single { NavigationStore(emptyList()) }
    single {
        viewModelFactory {
            initializer { AppViewModel(get()) }
            initializer { AppThemeViewModel(get()) }
            initializer { AppThemePersistenceViewModel(get(), get(), get()) }
            initializer { TemplateNoArgsViewModel(get()) }
            initializer { TemplateViewModel(get()) }
            initializer { ShowcasesViewModel(get()) }
            initializer { ChangeThemeViewModel(get(), get()) }
            initializer { ToggleThemeViewModel(get()) }
            initializer { BasicPagingViewModel(get(), get()) }
            initializer { BasicHttpViewModel(get(), get()) }
            initializer { NavigationAViewModel() }
            initializer { NavigationBViewModel() }
            initializer { NavigationCViewModel() }
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
            initializer { PasscodeViewModel(get(), get(), get(), get()) }
            initializer { CoilShowcaseViewModel(get()) }
            initializer { SetPasscodeViewModel(get(), get(), get(), get(), get()) }
            initializer { ResetPasscodeViewModel(get(), get(), get(), get()) }
            initializer { UnlockPasscodeViewModel(get(), get()) }
            initializer { ForgotPasscodeViewModel(get()) }
            initializer { MarkdownShowcaseViewModel(get()) }
            initializer { FilePickerShowcaseViewModel(get()) }
            initializer { GeminiViewModel(get(), get()) }
            initializer { createRoomCrudViewModel() }
        }
    }
}