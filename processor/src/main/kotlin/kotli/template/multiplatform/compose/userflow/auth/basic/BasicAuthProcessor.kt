package kotli.template.multiplatform.compose.userflow.auth.basic

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotli.template.multiplatform.compose.showcases.userflow.auth.AuthShowcasesProcessor
import kotlin.reflect.KClass
import kotlin.time.Duration.Companion.hours

object BasicAuthProcessor : BaseFeatureProcessor() {

    const val ID = "userflow.auth.basic"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getIntegrationEstimate(state: TemplateState): Long = 8.hours.inWholeMilliseconds

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        AuthShowcasesProcessor::class
    )

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.AppAuth,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppConfigKt,
            RemoveMarkedLine("auth")
        )
        state.onApplyRules(
            Rules.StringsXml,
            RemoveMarkedLine("auth_")
        )
        state.onApplyRules(
            "*/auth_*.xml",
            RemoveFile()
        )
    }
}