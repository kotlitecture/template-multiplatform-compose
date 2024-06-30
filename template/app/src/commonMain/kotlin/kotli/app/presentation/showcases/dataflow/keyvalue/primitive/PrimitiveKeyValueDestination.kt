package kotli.app.presentation.showcases.dataflow.keyvalue.primitive

import androidx.navigation.NavGraphBuilder
import shared.presentation.navigation.NavigationDestinationNoArgs
import shared.presentation.navigation.NavigationStrategy

object PrimitiveKeyValueDestination : NavigationDestinationNoArgs() {

    override val id: String = "primitive_key_value_showcase_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { PrimitiveKeyValueScreen() }

}