package kotli.template.multiplatform.compose.userflow.loader.data

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.dataflow.config.facade.FacadeConfigProcessor
import kotli.template.multiplatform.compose.showcases.feature.loader.data.DataLoaderShowcasesProcessor
import kotlin.time.Duration.Companion.hours

object DataLoaderProcessor : BaseFeatureProcessor() {

    const val ID = "userflow.loader.data"

    override fun getId(): String = ID
    override fun getIntegrationEstimate(state: TemplateState): Long = 1.hours.inWholeMilliseconds

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        FacadeConfigProcessor::class.java,
        DataLoaderShowcasesProcessor::class.java
    )

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.UserFlowDataLoaderDir,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppModuleKt,
            RemoveMarkedLine("LoaderViewModel")
        )
        state.onApplyRules(
            Rules.AppScreenKt,
            RemoveMarkedLine("LoaderProvider")
        )
        state.onApplyRules(
            Rules.AppConfigSource,
            RemoveMarkedLine("ui_loader_")
        )
    }

}