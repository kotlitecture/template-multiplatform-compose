package kotli.template.multiplatform.compose.userflow.theme.change

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotli.template.multiplatform.compose.showcases.userflow.theme.change.ChangeThemeShowcasesProcessor
import kotli.template.multiplatform.compose.userflow.theme.save.SaveThemeProcessor
import kotlin.reflect.KClass
import kotlin.time.Duration.Companion.hours

object ChangeThemeProcessor : BaseFeatureProcessor() {

    const val ID = "userflow.theme.change"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getIntegrationEstimate(state: TemplateState): Long = 1.hours.inWholeMilliseconds

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        SaveThemeProcessor::class,
        ChangeThemeShowcasesProcessor::class
    )

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.AppThemeConfigKt,
            RemoveMarkedLine("ChangeTheme")
        )
        state.onApplyRules(
            "${Rules.AppTheme}/change",
            RemoveFile()
        )
        state.onApplyRules(
            Rules.StringsXml,
            RemoveMarkedLine("theme_change_")
        )
    }

}