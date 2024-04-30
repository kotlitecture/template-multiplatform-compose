package kotli.template.multiplatform.compose.essentials

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureType
import kotli.engine.model.FeatureTypes

abstract class EssentialsProvider : BaseFeatureProvider() {

    override fun isRequired(): Boolean = true
    override fun isMultiple(): Boolean = false
    override fun getType(): FeatureType = FeatureTypes.Essentials

}