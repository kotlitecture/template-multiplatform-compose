package kotli.template.multiplatform.compose.userflow.theme.save

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.engine.template.rule.ReplaceText
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotli.template.multiplatform.compose.dataflow.keyvalue.settings.SettingsKeyValueProcessor
import kotlin.time.Duration.Companion.hours

object SaveThemeProcessor : BaseFeatureProcessor() {

    const val ID = "userflow.theme.save"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getIntegrationEstimate(state: TemplateState): Long = 2.hours.inWholeMilliseconds
    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        SettingsKeyValueProcessor::class.java
    )

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.AppThemeViewModelKt,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppModuleKt,
            RemoveMarkedLine("AppThemeViewModel")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.ThemeStoreKt,
            RemoveMarkedLine(
                marker = "theme_config",
                singleLine = true
            )
        )
        state.onApplyRules(
            Rules.AppThemeConfigDataKt,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppThemePersistenceViewModelKt,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppModuleKt,
            RemoveMarkedLine("AppThemePersistenceViewModel")
        )
        state.onApplyRules(
            Rules.AppThemeProviderKt,
            ReplaceText(
                text = "AppThemePersistenceViewModel",
                replacer = "AppThemeViewModel"
            )
        )
    }

}