package app.showcases.datasource.http.basic

import androidx.navigation.NavGraphBuilder
import core.ui.navigation.NavigationDestinationNoArgs
import core.ui.navigation.NavigationStrategy

object BasicHttpDestination : NavigationDestinationNoArgs() {

    override val id: String = "basic_http_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { BasicHttpScreen() }

}