package kotli.template.multiplatform.compose.userflow.component

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.CleanupMarkedLine
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotlin.time.Duration.Companion.hours

object ComponentProcessor : BaseFeatureProcessor() {

    const val ID = "userflow.component"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true
    override fun getTags(): List<FeatureTag> = Tags.AllClients

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.ShowcasesKt,
            RemoveMarkedLine("Userflow :: Design Components")
        )
    }

}