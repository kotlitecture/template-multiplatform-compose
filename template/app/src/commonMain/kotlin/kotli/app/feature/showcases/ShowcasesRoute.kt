package kotli.app.feature.showcases

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import kotli.app.AppRoute
import kotli.app.feature.showcases.presentation.ShowcasesScreen
import kotli.app.feature.showcases.presentation.dataflow.ai.gemini.GeminiRoute
import kotli.app.feature.showcases.presentation.dataflow.ai.gemini.GeminiScreen
import kotli.app.feature.showcases.presentation.dataflow.cache.basic.BasicCacheRoute
import kotli.app.feature.showcases.presentation.dataflow.cache.basic.BasicCacheScreen
import kotli.app.feature.showcases.presentation.dataflow.encryption.BasicEncryptionRoute
import kotli.app.feature.showcases.presentation.dataflow.encryption.BasicEncryptionScreen
import kotli.app.feature.showcases.presentation.dataflow.http.basic.BasicHttpRoute
import kotli.app.feature.showcases.presentation.dataflow.http.basic.BasicHttpScreen
import kotli.app.feature.showcases.presentation.dataflow.keyvalue.`object`.ObjectKeyValueRoute
import kotli.app.feature.showcases.presentation.dataflow.keyvalue.`object`.ObjectKeyValueScreen
import kotli.app.feature.showcases.presentation.dataflow.keyvalue.primitive.PrimitiveKeyValueRoute
import kotli.app.feature.showcases.presentation.dataflow.keyvalue.primitive.PrimitiveKeyValueScreen
import kotli.app.feature.showcases.presentation.dataflow.paging.basic.BasicPagingRoute
import kotli.app.feature.showcases.presentation.dataflow.paging.basic.BasicPagingScreen
import kotli.app.feature.showcases.presentation.dataflow.room.crud.RoomCrudRoute
import kotli.app.feature.showcases.presentation.dataflow.room.crud.RoomCrudScreen
import kotli.app.feature.showcases.presentation.dataflow.sqldelight.crud.SqlDelightCrudRoute
import kotli.app.feature.showcases.presentation.dataflow.sqldelight.crud.SqlDelightCrudScreen
import kotli.app.feature.showcases.presentation.dataflow.sqldelight.paging.SqlDelightPagingRoute
import kotli.app.feature.showcases.presentation.dataflow.sqldelight.paging.SqlDelightPagingScreen
import kotli.app.feature.showcases.presentation.userflow.component.filepicker.FilePickerRoute
import kotli.app.feature.showcases.presentation.userflow.component.filepicker.FilePickerScreen
import kotli.app.feature.showcases.presentation.userflow.component.image.coil.CoilRoute
import kotli.app.feature.showcases.presentation.userflow.component.image.coil.CoilScreen
import kotli.app.feature.showcases.presentation.userflow.component.markdown.MarkdownRoute
import kotli.app.feature.showcases.presentation.userflow.component.markdown.MarkdownScreen
import kotli.app.feature.showcases.presentation.userflow.component.placeholder.PlaceholderRoute
import kotli.app.feature.showcases.presentation.userflow.component.placeholder.PlaceholderScreen
import kotli.app.feature.showcases.presentation.userflow.loader.LoaderRoute
import kotli.app.feature.showcases.presentation.userflow.loader.LoaderScreen
import kotli.app.feature.showcases.presentation.userflow.theme.toggle.ToggleThemeRoute
import kotli.app.feature.showcases.presentation.userflow.theme.toggle.ToggleThemeScreen
import kotlinx.serialization.Serializable
import shared.presentation.misc.back
import shared.presentation.misc.newInstance

@Serializable
object ShowcasesRoute : AppRoute

fun NavGraphBuilder.showcases(navController: NavHostController) {
    composable<ShowcasesRoute> { ShowcasesScreen { screen -> navController.newInstance(screen.route) } }
    composable<FilePickerRoute> { FilePickerScreen(navController::back) }
    composable<CoilRoute> { CoilScreen(navController::back) }
    composable<MarkdownRoute> { MarkdownScreen(navController::back) }
    composable<PlaceholderRoute> { PlaceholderScreen(navController::back) }
    composable<LoaderRoute> { LoaderScreen(navController::back) }
    dialog<ToggleThemeRoute> { ToggleThemeScreen() }
    composable<GeminiRoute> { GeminiScreen(navController::back) }
    composable<BasicCacheRoute> { BasicCacheScreen(navController::back) }
    composable<BasicEncryptionRoute> { BasicEncryptionScreen(navController::back) }
    composable<BasicHttpRoute> { BasicHttpScreen(navController::back) }
    composable<ObjectKeyValueRoute> { ObjectKeyValueScreen(navController::back) }
    composable<PrimitiveKeyValueRoute> { PrimitiveKeyValueScreen(navController::back) }
    composable<BasicPagingRoute> { BasicPagingScreen(navController::back) }
    composable<RoomCrudRoute> { RoomCrudScreen(navController::back) }
    composable<SqlDelightCrudRoute> { SqlDelightCrudScreen(navController::back) }
    composable<SqlDelightPagingRoute> { SqlDelightPagingScreen(navController::back) }
}