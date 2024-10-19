package kotli.app.feature.showcases.presentation.userflow.component.filepicker

import kotli.app.AppRoute
import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object FilePickerRoute : AppRoute {

    val screen = Showcase.Screen("File Picker", this)

}