package kotli.template.multiplatform.compose.platform

import kotli.engine.FeatureType
import kotli.engine.utils.ResourceUtils
import java.net.URL

object PlatformType : FeatureType {
    override fun getId(): String = "platform"
    override fun getOrder(): Int = -2
    override fun getIcon(): URL? = ResourceUtils.get(this, "feature_type_platform.svg")
    override fun getTitle(): String? = ResourceUtils.getAsString(this, "feature_type_platform_title.md")
    override fun getDescription(): String? = ResourceUtils.getAsString(this, "feature_type_platform_description.md", true)
}