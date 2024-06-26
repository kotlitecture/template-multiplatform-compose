package kotli.app.presentation.showcases.dataflow.keyvalue.`object`

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs
import shared.presentation.navigation.NavigationStrategy

object ObjectKeyValueDestination : NavigationDestinationNoArgs() {

    override val id: String = "object_key_value_showcase_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { ObjectKeyValueScreen() }

}