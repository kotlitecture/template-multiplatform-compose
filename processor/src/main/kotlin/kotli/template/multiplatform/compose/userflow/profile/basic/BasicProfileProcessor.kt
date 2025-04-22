package kotli.template.multiplatform.compose.userflow.profile.basic

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotlin.reflect.KClass

object BasicProfileProcessor : BaseFeatureProcessor() {

    const val ID = "userflow.profile.basic"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true
    override fun getTags(): List<FeatureTag> = Tags.AllClients

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf()

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.AppProfile,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppConfigKt,
            RemoveMarkedLine("profile")
        )
        state.onApplyRules(
            Rules.StringsXml,
            RemoveMarkedLine("profile_")
        )
    }
}