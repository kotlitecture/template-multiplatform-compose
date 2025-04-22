package kotli.app.showcases.presentation.userflow.common.component.filepicker

import kotli.app.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object FilePickerRoute {

    val screen = Showcase.Screen("File Picker", this)

}