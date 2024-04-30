import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import app.App
import org.jetbrains.compose.resources.stringResource
import template.composeapp.generated.resources.Res
import template.composeapp.generated.resources.app_name

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = stringResource(Res.string.app_name)
    ) {
        App()
    }
}