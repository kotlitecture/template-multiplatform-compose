package kotli.app.feature.showcases.presentation.dataflow.paging.basic

import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object BasicPagingRoute {

    val screen = Showcase.Screen("Basic Paging Usage", this)

}