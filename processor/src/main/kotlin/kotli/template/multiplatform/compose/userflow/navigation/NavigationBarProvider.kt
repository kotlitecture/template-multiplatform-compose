package kotli.template.multiplatform.compose.userflow.navigation

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureType
import kotli.engine.model.FeatureTypes
import kotli.template.multiplatform.compose.userflow.navigation.adaptive.AdaptiveNavigationProcessor
import kotli.template.multiplatform.compose.userflow.navigation.bottom.BottomNavigationProcessor
import kotli.template.multiplatform.compose.userflow.navigation.dismissible.DismissibleNavigationProcessor
import kotli.template.multiplatform.compose.userflow.navigation.modal.ModalNavigationProcessor
import kotli.template.multiplatform.compose.userflow.navigation.permanent.PermanentNavigationProcessor
import kotli.template.multiplatform.compose.userflow.navigation.rail.RailNavigationProcessor

object NavigationBarProvider : BaseFeatureProvider() {

    override fun getId(): String = "userflow.navigation"
    override fun isMultiple(): Boolean = false
    override fun getType(): FeatureType = FeatureTypes.UserFlow

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        NavigationBarProcessor::class.java
    )

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        NavigationBarProcessor,
        AdaptiveNavigationProcessor,
        BottomNavigationProcessor,
        DismissibleNavigationProcessor,
        ModalNavigationProcessor,
        PermanentNavigationProcessor,
        RailNavigationProcessor
    )

}