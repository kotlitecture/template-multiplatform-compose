import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import app.App
import org.jetbrains.compose.resources.stringResource
import template.composeapp.generated.resources.Res
import template.composeapp.generated.resources.app_name

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = stringResource(Res.string.app_name),
        state = rememberWindowState(
            size = DpSize(480.dp, 640.dp)
        )
    ) {
        App()
    }
}