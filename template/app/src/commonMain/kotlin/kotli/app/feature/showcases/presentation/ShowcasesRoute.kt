package kotli.app.feature.showcases.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotli.app.AppRoute
import kotli.app.feature.passcode.reset.presentation.ResetPasscodeScreen
import kotli.app.feature.passcode.set.presentation.SetPasscodeScreen
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
import kotli.app.feature.showcases.presentation.userflow.passcode.ResetPasscodeRoute
import kotli.app.feature.showcases.presentation.userflow.passcode.SetPasscodeRoute
import kotli.app.feature.showcases.presentation.userflow.theme.change.ChangeThemeDialogRoute
import kotli.app.feature.showcases.presentation.userflow.theme.change.ChangeThemeScreenRoute
import kotli.app.feature.showcases.presentation.userflow.theme.toggle.ToggleThemeRoute
import kotli.app.feature.showcases.presentation.userflow.theme.toggle.ToggleThemeScreen
import kotli.app.feature.theme.change.presentation.ChangeThemeDialog
import kotli.app.feature.theme.change.presentation.ChangeThemeScreen
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
    composable<ResetPasscodeRoute> { ResetPasscodeScreen(navController::back) }
    composable<SetPasscodeRoute> { SetPasscodeScreen(navController::back) }
    composable<ChangeThemeScreenRoute> { ChangeThemeScreen() }
    composable<ChangeThemeDialogRoute> { ChangeThemeDialog() }
    composable<ToggleThemeRoute> { ToggleThemeScreen() }
}