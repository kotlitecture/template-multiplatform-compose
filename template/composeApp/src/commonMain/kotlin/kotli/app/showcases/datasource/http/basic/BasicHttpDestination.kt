package kotli.app.showcases.datasource.http.basic

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs
import shared.presentation.navigation.NavigationStrategy

object BasicHttpDestination : NavigationDestinationNoArgs() {

    override val id: String = "basic_http_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { BasicHttpScreen() }

}