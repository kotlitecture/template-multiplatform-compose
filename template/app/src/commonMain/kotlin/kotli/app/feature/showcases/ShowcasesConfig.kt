package kotli.app.feature.showcases

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.lifecycle.viewmodel.initializer
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import kotli.app.di.inject
import kotli.app.di.platform.createRoomCrudViewModel
import kotli.app.feature.showcases.presentation.ShowcasesRoute
import kotli.app.feature.showcases.presentation.ShowcasesScreen
import kotli.app.feature.showcases.presentation.ShowcasesViewModel
import kotli.app.feature.showcases.presentation.dataflow.ai.gemini.GeminiRoute
import kotli.app.feature.showcases.presentation.dataflow.ai.gemini.GeminiScreen
import kotli.app.feature.showcases.presentation.dataflow.ai.gemini.GeminiViewModel
import kotli.app.feature.showcases.presentation.dataflow.cache.basic.BasicCacheRoute
import kotli.app.feature.showcases.presentation.dataflow.cache.basic.BasicCacheScreen
import kotli.app.feature.showcases.presentation.dataflow.cache.basic.BasicCacheViewModel
import kotli.app.feature.showcases.presentation.dataflow.encryption.BasicEncryptionRoute
import kotli.app.feature.showcases.presentation.dataflow.encryption.BasicEncryptionScreen
import kotli.app.feature.showcases.presentation.dataflow.encryption.BasicEncryptionViewModel
import kotli.app.feature.showcases.presentation.dataflow.http.basic.BasicHttpRoute
import kotli.app.feature.showcases.presentation.dataflow.http.basic.BasicHttpScreen
import kotli.app.feature.showcases.presentation.dataflow.http.basic.BasicHttpViewModel
import kotli.app.feature.showcases.presentation.dataflow.settings.`object`.ObjectSettingsRoute
import kotli.app.feature.showcases.presentation.dataflow.settings.`object`.ObjectSettingsScreen
import kotli.app.feature.showcases.presentation.dataflow.settings.`object`.ObjectSettingsViewModel
import kotli.app.feature.showcases.presentation.dataflow.settings.primitive.PrimitiveSettingsRoute
import kotli.app.feature.showcases.presentation.dataflow.settings.primitive.PrimitiveSettingsScreen
import kotli.app.feature.showcases.presentation.dataflow.settings.primitive.PrimitiveSettingsViewModel
import kotli.app.feature.showcases.presentation.dataflow.paging.basic.BasicPagingRoute
import kotli.app.feature.showcases.presentation.dataflow.paging.basic.BasicPagingScreen
import kotli.app.feature.showcases.presentation.dataflow.paging.basic.BasicPagingViewModel
import kotli.app.feature.showcases.presentation.dataflow.room.crud.RoomCrudRoute
import kotli.app.feature.showcases.presentation.dataflow.room.crud.RoomCrudScreen
import kotli.app.feature.showcases.presentation.dataflow.sqldelight.crud.SqlDelightCrudRoute
import kotli.app.feature.showcases.presentation.dataflow.sqldelight.crud.SqlDelightCrudScreen
import kotli.app.feature.showcases.presentation.dataflow.sqldelight.crud.SqlDelightCrudViewModel
import kotli.app.feature.showcases.presentation.dataflow.sqldelight.paging.SqlDelightPagingRoute
import kotli.app.feature.showcases.presentation.dataflow.sqldelight.paging.SqlDelightPagingScreen
import kotli.app.feature.showcases.presentation.dataflow.sqldelight.paging.SqlDelightPagingViewModel
import kotli.app.feature.showcases.presentation.userflow.component.filepicker.FilePickerRoute
import kotli.app.feature.showcases.presentation.userflow.component.filepicker.FilePickerScreen
import kotli.app.feature.showcases.presentation.userflow.component.filepicker.FilePickerViewModel
import kotli.app.feature.showcases.presentation.userflow.component.image.coil.CoilRoute
import kotli.app.feature.showcases.presentation.userflow.component.image.coil.CoilScreen
import kotli.app.feature.showcases.presentation.userflow.component.markdown.MarkdownRoute
import kotli.app.feature.showcases.presentation.userflow.component.markdown.MarkdownScreen
import kotli.app.feature.showcases.presentation.userflow.component.placeholder.PlaceholderRoute
import kotli.app.feature.showcases.presentation.userflow.component.placeholder.PlaceholderScreen
import kotli.app.feature.showcases.presentation.userflow.component.placeholder.PlaceholderViewModel
import kotli.app.feature.showcases.presentation.userflow.loader.advanced.AdvancedLoaderRoute
import kotli.app.feature.showcases.presentation.userflow.loader.advanced.AdvancedLoaderScreen
import kotli.app.feature.showcases.presentation.userflow.loader.advanced.AdvancedLoaderViewModel
import kotli.app.feature.showcases.presentation.userflow.loader.basic.BasicLoaderRoute
import kotli.app.feature.showcases.presentation.userflow.loader.basic.BasicLoaderScreen
import kotli.app.feature.showcases.presentation.userflow.loader.basic.BasicLoaderViewModel
import kotli.app.feature.showcases.presentation.userflow.theme.toggle.ToggleThemeRoute
import kotli.app.feature.showcases.presentation.userflow.theme.toggle.ToggleThemeScreen
import shared.presentation.misc.back
import shared.presentation.misc.newInstance

fun NavGraphBuilder.showcases(navController: NavHostController) {
    composable<ShowcasesRoute> { ShowcasesScreen(navController::newInstance) }
    composable<FilePickerRoute> { FilePickerScreen(navController::back) }
    composable<CoilRoute> { CoilScreen(navController::back) }
    composable<MarkdownRoute> { MarkdownScreen(navController::back) }
    composable<PlaceholderRoute> { PlaceholderScreen(navController::back) }
    composable<BasicLoaderRoute> { BasicLoaderScreen(navController::back) }
    composable<AdvancedLoaderRoute> { AdvancedLoaderScreen(navController::back) }
    dialog<ToggleThemeRoute> { ToggleThemeScreen() }
    composable<GeminiRoute> { GeminiScreen(navController::back) }
    composable<BasicCacheRoute> { BasicCacheScreen(navController::back) }
    composable<BasicEncryptionRoute> { BasicEncryptionScreen(navController::back) }
    composable<BasicHttpRoute> { BasicHttpScreen(navController::back) }
    composable<ObjectSettingsRoute> { ObjectSettingsScreen(navController::back) }
    composable<PrimitiveSettingsRoute> { PrimitiveSettingsScreen(navController::back) }
    composable<BasicPagingRoute> { BasicPagingScreen(navController::back) }
    composable<RoomCrudRoute> { RoomCrudScreen(navController::back) }
    composable<SqlDelightCrudRoute> { SqlDelightCrudScreen(navController::back) }
    composable<SqlDelightPagingRoute> { SqlDelightPagingScreen(navController::back) }
}

fun InitializerViewModelFactoryBuilder.showcases() {
    initializer { ShowcasesViewModel() }
    initializer { BasicPagingViewModel(inject()) }
    initializer { BasicHttpViewModel(inject()) }
    initializer { BasicLoaderViewModel() }
    initializer { AdvancedLoaderViewModel() }
    initializer { PrimitiveSettingsViewModel(inject()) }
    initializer { ObjectSettingsViewModel(inject()) }
    initializer { SqlDelightCrudViewModel(inject()) }
    initializer { SqlDelightPagingViewModel(inject(), inject(), inject()) }
    initializer { BasicCacheViewModel(inject()) }
    initializer { PlaceholderViewModel() }
    initializer { BasicEncryptionViewModel(inject()) }
    initializer { FilePickerViewModel() }
    initializer { GeminiViewModel(inject()) }
    initializer { createRoomCrudViewModel() }
}