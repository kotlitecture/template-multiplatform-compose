package kotli.template.multiplatform.compose.dataflow.database.sqldelight

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.CleanupMarkedBlock
import kotli.engine.template.rule.CleanupMarkedLine
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedBlock
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.engine.template.rule.RenamePackage
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.dataflow.paging.cashapp.CashAppPagingProcessor
import kotlin.time.Duration.Companion.hours

object SqlDelightProcessor : BaseFeatureProcessor() {

    const val ID = "dataflow.database.sqldelight"

    override fun getId(): String = ID
    override fun getWebUrl(state: TemplateState): String = "https://cashapp.github.io/sqldelight/"
    override fun getIntegrationUrl(state: TemplateState): String =
        "https://cashapp.github.io/sqldelight/2.0.2/multiplatform_sqlite/"

    override fun getIntegrationEstimate(state: TemplateState): Long = 4.hours.inWholeMilliseconds

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.BuildGradleApp,
            CleanupMarkedBlock("{sqldelight.config}"),
            CleanupMarkedLine("{dataflow.database.sqldelight}")
        )
        state.onApplyRules(
            "${Rules.CommonAppMainDir}/sqldelight",
            RenamePackage(
                "kotli.app",
                state.layer.namespace
            )
        )
        applyPaging(state)
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.BuildGradleApp,
            RemoveMarkedBlock("{sqldelight.config}"),
            RemoveMarkedLine("{dataflow.database.sqldelight}")
        )
        state.onApplyRules(
            Rules.AppSqlDelightConfigJs,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppSqlDelightDir,
            RemoveFile()
        )
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("touchlab-stately"),
                RemoveMarkedLine("sqldelight")
            )
        )
        state.onApplyRules(
            Rules.SqlDelightSource,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppDIKt,
            RemoveMarkedLine("SqlDelightSource")
        )
        state.onApplyRules(
            Rules.ShowcasesKt,
            RemoveMarkedLine("SqlDelight")
        )
        state.onApplyRules(
            Rules.ShowcasesSqlDelightDir,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppKt,
            RemoveMarkedLine("SqlDelight")
        )
    }

    private fun applyPaging(state: TemplateState) {
        if (state.getFeature(CashAppPagingProcessor.ID) != null) return

        state.onApplyRules(
            Rules.BuildGradleApp,
            RemoveMarkedLine("sqldelight.androidx.paging"),
        )
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("sqldelight-androidx-paging")
            )
        )
        state.onApplyRules(
            "${Rules.ShowcasesSqlDelightDir}/paging",
            RemoveFile()
        )
        state.onApplyRules(
            Rules.ShowcasesKt,
            RemoveMarkedLine("SqlDelightPaging")
        )
        state.onApplyRules(
            Rules.AppKt,
            RemoveMarkedLine("SqlDelightPaging")
        )
    }

}