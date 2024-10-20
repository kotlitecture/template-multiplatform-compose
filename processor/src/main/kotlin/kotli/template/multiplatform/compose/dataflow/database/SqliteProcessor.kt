package kotli.template.multiplatform.compose.dataflow.database

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.CleanupMarkedLine
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules

object SqliteProcessor : BaseFeatureProcessor() {

    const val ID = "dataflow.database.sqlite"
    override fun isInternal(): Boolean = true
    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        SqliteLinkerProcessor::class.java
    )

    override fun getId(): String = ID

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.AppBuildGradle,
            CleanupMarkedLine("{dataflow.database.sqlite}")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.AppBuildGradle,
            RemoveMarkedLine("{dataflow.database.sqlite}")
        )
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("sqlite-bundled")
            )
        )
    }

}