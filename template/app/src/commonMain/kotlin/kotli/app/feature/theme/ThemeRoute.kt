package kotli.app.feature.theme

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import kotli.app.feature.theme.change.presentation.ChangeThemeDialog
import kotli.app.feature.theme.change.presentation.ChangeThemeDialogRoute
import kotli.app.feature.theme.change.presentation.ChangeThemeRoute
import kotli.app.feature.theme.change.presentation.ChangeThemeScreen
import shared.presentation.misc.back

fun NavGraphBuilder.theme(navController: NavHostController) {
    composable<ChangeThemeRoute> { ChangeThemeScreen(navController::back) }
    dialog<ChangeThemeDialogRoute> { ChangeThemeDialog() }
}