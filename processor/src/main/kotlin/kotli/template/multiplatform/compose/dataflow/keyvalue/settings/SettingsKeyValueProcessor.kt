package kotli.template.multiplatform.compose.dataflow.keyvalue.settings

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.CleanupMarkedLine
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotli.template.multiplatform.compose.dataflow.keyvalue.common.CommonKeyValueProcessor
import kotlin.time.Duration.Companion.minutes

object SettingsKeyValueProcessor : BaseFeatureProcessor() {

    const val ID = "dataflow.keyvalue.settings"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getWebUrl(state: TemplateState): String = "https://github.com/russhwolf/multiplatform-settings"
    override fun getIntegrationUrl(state: TemplateState): String = "https://github.com/russhwolf/multiplatform-settings?tab=readme-ov-file#no-arg-module"
    override fun getIntegrationEstimate(state: TemplateState): Long = 30.minutes.inWholeMilliseconds
    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        CommonKeyValueProcessor::class.java
    )

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.BuildGradleSharedData,
            CleanupMarkedLine("{dataflow.keyvalue.settings}")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.SettingsKeyValueSource,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.BuildGradleSharedData,
            RemoveMarkedLine("multiplatform.settings")
        )
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("multiplatform-settings")
            )
        )
    }

}