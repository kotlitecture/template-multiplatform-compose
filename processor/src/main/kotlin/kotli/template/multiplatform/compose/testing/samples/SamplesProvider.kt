package kotli.template.multiplatform.compose.testing.samples

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureType
import kotli.engine.model.FeatureTypes
import kotli.template.multiplatform.compose.testing.samples.showcases.ShowcasesProcessor

object SamplesProvider : BaseFeatureProvider() {

    override fun getId(): String = "testing.samples"
    override fun isMultiple(): Boolean = true
    override fun getType(): FeatureType = FeatureTypes.Testing
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        ShowcasesProcessor
    )

}