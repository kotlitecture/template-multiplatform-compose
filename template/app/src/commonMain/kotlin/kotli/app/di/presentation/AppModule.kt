package kotli.app.di.presentation

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotli.app.AppNavigationRouter
import kotli.app.AppStore
import kotli.app.AppViewModel
import kotli.app.presentation.navigation.NavigationBarViewModel
import kotli.app.presentation.navigation.samples.a.NavigationAViewModel
import kotli.app.presentation.navigation.samples.b.NavigationBViewModel
import kotli.app.presentation.navigation.samples.c.NavigationCViewModel
import kotli.app.presentation.ui.theme.change.ChangeThemeViewModel
import kotli.app.presentation.ui.theme.toggle.ToggleThemeViewModel
import kotli.app.showcases.ShowcasesViewModel
import kotli.app.showcases.datasource.cache.basic.BasicCacheViewModel
import kotli.app.showcases.datasource.http.basic.BasicHttpViewModel
import kotli.app.showcases.datasource.keyvalue.`object`.ObjectKeyValueViewModel
import kotli.app.showcases.datasource.keyvalue.primitive.PrimitiveKeyValueViewModel
import kotli.app.showcases.datasource.paging.basic.BasicPagingViewModel
import kotli.app.showcases.datasource.sqldelight.crud.SqlDelightCrudViewModel
import kotli.app.showcases.datasource.sqldelight.paging.SqlDelightPagingViewModel
import kotli.app.showcases.feature.loader.data.DataLoaderShowcaseViewModel
import kotli.app.showcases.navigation.args.from.ArgsNavigationFromViewModel
import kotli.app.showcases.navigation.args.to.ArgsNavigationToViewModel
import kotli.app.showcases.navigation.no_args.from.NoArgsNavigationFromViewModel
import kotli.app.showcases.navigation.no_args.to.NoArgsNavigationToViewModel
import kotli.app.presentation.ui.loader.LoaderViewModel
import kotli.app.ui.screen.template.TemplateViewModel
import kotli.app.ui.screen.template_no_args.TemplateNoArgsViewModel
import kotli.app.presentation.theme.AppThemePersistenceViewModel
import kotli.app.presentation.theme.AppThemeViewModel
import org.koin.dsl.module
import shared.design.component.AppSnackbarStore

val appModule = module {
    single { AppStore() }
    single { AppSnackbarStore() }
    single { AppNavigationRouter() }
    single {
        viewModelFactory {
            initializer { AppViewModel(get(), get(), get(), get()) }
            initializer { AppThemeViewModel(get()) }
            initializer { AppThemePersistenceViewModel(get(), get()) }
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
            initializer { NavigationBarViewModel(get(), get()) }
            initializer { NoArgsNavigationFromViewModel(get()) }
            initializer { NoArgsNavigationToViewModel(get()) }
            initializer { ArgsNavigationFromViewModel(get()) }
            initializer { ArgsNavigationToViewModel(get()) }
            initializer { LoaderViewModel(get()) }
            initializer { DataLoaderShowcaseViewModel(get(), get()) }
            initializer { PrimitiveKeyValueViewModel(get(), get()) }
            initializer { ObjectKeyValueViewModel(get(), get()) }
            initializer { SqlDelightCrudViewModel(get(), get()) }
            initializer { SqlDelightPagingViewModel(get(), get(), get(), get()) }
            initializer { BasicCacheViewModel(get(), get()) }
        }
    }
}