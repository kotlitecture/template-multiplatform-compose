package kotli.app.showcases.presentation.userflow.common.component.markdown

import kotli.app.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object MarkdownRoute {

    val screen = Showcase.Screen("Markdown Text", this)

}