package kotli.template.multiplatform.compose.platform

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.CleanupMarkedBlock
import kotli.engine.template.rule.CleanupMarkedLine
import kotli.engine.template.rule.RemoveMarkedBlock
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotlin.reflect.KClass
import kotlin.time.Duration.Companion.hours

abstract class PlatformProcessor : BaseFeatureProcessor() {

    override fun getWebUrl(state: TemplateState): String = "https://www.jetbrains.com/lp/compose-multiplatform/"
    override fun getIntegrationUrl(state: TemplateState): String = "https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-multiplatform-getting-started.html"
    override fun getIntegrationEstimate(state: TemplateState): Long = 1.hours.inWholeMilliseconds
    override fun dependencies(): List<KClass<out FeatureProcessor>> = emptyList()

    protected val platformLine by lazy { "{${getId()}}" }
    protected val targetBlock by lazy { "{${getId()}.target}" }
    protected val configBlock by lazy { "{${getId()}.config}" }
    protected val dependenciesBlock by lazy { "{${getId()}.dependencies}" }

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.BuildGradle,
            CleanupMarkedLine(platformLine),
            CleanupMarkedBlock(targetBlock),
            CleanupMarkedBlock(configBlock),
            CleanupMarkedBlock(dependenciesBlock),
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.BuildGradle,
            RemoveMarkedLine(platformLine),
            RemoveMarkedBlock(targetBlock),
            RemoveMarkedBlock(configBlock),
            RemoveMarkedBlock(dependenciesBlock),
        )
    }

}