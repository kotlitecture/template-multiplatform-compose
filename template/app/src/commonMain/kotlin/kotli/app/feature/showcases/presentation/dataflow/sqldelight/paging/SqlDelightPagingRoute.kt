package kotli.app.feature.showcases.presentation.dataflow.sqldelight.paging

import kotli.app.AppRoute
import kotli.app.feature.showcases.domain.Showcase
import kotli.app.feature.showcases.presentation.ShowcasesViewModel
import kotlinx.serialization.Serializable
import shared.presentation.navigation.NavigationDestination

@Serializable
object SqlDelightPagingRoute : AppRoute {

    val screen = Showcase.Screen("SqlDelight Paging", this)

}