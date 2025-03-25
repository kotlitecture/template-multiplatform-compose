package kotli.template.multiplatform.compose.platform.client.js

import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.model.FeatureTags
import kotli.engine.template.rule.CleanupMarkedBlock
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedBlock
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.platform.PlatformProcessor

object JsPlatformProcessor : PlatformProcessor() {

    const val ID = "platform.js"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = listOf(FeatureTags.Client, FeatureTags.Web)

    override fun doApply(state: TemplateState) {
        super.doApply(state)
        state.onApplyRules(
            Rules.BackendBuildGradle,
            CleanupMarkedBlock(configBlock)
        )
    }

    override fun doRemove(state: TemplateState) {
        super.doRemove(state)
        state.onApplyRules(
            Rules.JsSrcDir,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.BackendBuildGradle,
            RemoveMarkedBlock(configBlock)
        )
        state.onApplyRules(
            Rules.AppWebPackConfigDir,
            RemoveFile()
        )
    }

}