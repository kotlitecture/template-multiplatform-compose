package kotli.template.multiplatform.compose.testing.logging

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureType
import kotli.engine.model.FeatureTypes
import kotli.template.multiplatform.compose.testing.logging.kermit.KermitProcessor
import kotli.template.multiplatform.compose.testing.logging.napier.NapierProcessor
import kotli.template.multiplatform.compose.testing.logging.oshai.OshaiProcessor

object LoggingProvider : BaseFeatureProvider() {

    override fun getId(): String = "testing.logging"
    override fun isMultiple(): Boolean = false
    override fun getType(): FeatureType = FeatureTypes.Testing
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        OshaiProcessor,
        KermitProcessor,
        NapierProcessor
    )

}