package kotli.template.multiplatform.compose.guides.samples

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureType
import kotli.engine.model.FeatureTypes
import kotli.template.multiplatform.compose.guides.samples.showcases.ShowcasesProcessor

object SamplesProvider : BaseFeatureProvider() {

    override fun getId(): String = "guides.samples"
    override fun isMultiple(): Boolean = true
    override fun getType(): FeatureType = FeatureTypes.Guides
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        ShowcasesProcessor
    )

}