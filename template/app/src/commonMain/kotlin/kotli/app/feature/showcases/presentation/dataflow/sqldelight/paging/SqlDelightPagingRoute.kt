package kotli.app.feature.showcases.presentation.dataflow.sqldelight.paging

import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object SqlDelightPagingRoute {

    val screen = Showcase.Screen("SqlDelight Paging", this)

}