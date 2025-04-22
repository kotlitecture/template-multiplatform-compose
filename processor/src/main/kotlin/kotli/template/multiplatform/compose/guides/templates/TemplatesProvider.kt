package kotli.template.multiplatform.compose.guides.templates

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureType
import kotli.engine.model.FeatureTypes
import kotli.template.multiplatform.compose.guides.templates.feature.FeatureTemplateProcessor

object TemplatesProvider : BaseFeatureProvider() {

    override fun getId(): String = "guides.templates"
    override fun isMultiple(): Boolean = true
    override fun getType(): FeatureType = FeatureTypes.Guides
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        FeatureTemplateProcessor
    )

}