package kotli.template.multiplatform.compose.dataflow.database.sqldelight

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.CleanupMarkedBlock
import kotli.engine.template.rule.CleanupMarkedLine
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedBlock
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.engine.template.rule.RenamePackage
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotli.template.multiplatform.compose.common.CommonStatelyProcessor
import kotli.template.multiplatform.compose.dataflow.database.DatabaseCommonProcessor
import kotli.template.multiplatform.compose.dataflow.database.SqliteProcessor
import kotli.template.multiplatform.compose.dataflow.paging.multiplatform.MultiplatformPagingProcessor
import kotli.template.multiplatform.compose.platform.client.MobileAndDesktopProcessor
import kotli.template.multiplatform.compose.showcases.dataflow.database.sqldelight.SqlDelightShowcasesProcessor
import kotlin.time.Duration.Companion.hours

object SqlDelightProcessor : BaseFeatureProcessor() {

    const val ID = "dataflow.database.sqldelight"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getWebUrl(state: TemplateState): String = "https://cashapp.github.io/sqldelight/"
    override fun getIntegrationUrl(state: TemplateState): String =
        "https://cashapp.github.io/sqldelight/2.0.2/multiplatform_sqlite/"

    override fun getIntegrationEstimate(state: TemplateState): Long = 4.hours.inWholeMilliseconds

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        SqlDelightShowcasesProcessor::class.java,
        MobileAndDesktopProcessor::class.java,
        DatabaseCommonProcessor::class.java,
        CommonStatelyProcessor::class.java,
        SqliteProcessor::class.java
    )

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.AppBuildGradle,
            CleanupMarkedBlock("{sqldelight.config}"),
            CleanupMarkedLine("{dataflow.database.sqldelight}")
        )
        state.onApplyRules(
            "${Rules.AppCommonMain}/sqldelight",
            RenamePackage(
                "kotli.app",
                state.layer.namespace
            )
        )
        state.onApplyRules(
            Rules.AppPlatformConfigKt,
            CleanupMarkedBlock("{dataflow.database.sqldelight}")
        )
        removePaging(state)
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.AppBuildGradle,
            RemoveMarkedBlock("{sqldelight.config}"),
            RemoveMarkedLine("{dataflow.database.sqldelight}")
        )
        state.onApplyRules(
            Rules.AppSqlDelightConfigJs,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.SqlDelightDir,
            RemoveFile()
        )
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("sqldelight"),
                RemoveMarkedLine("stately-common"),
                RemoveMarkedLine("stately-isolate"),
                RemoveMarkedLine("stately-iso-collections"),
            )
        )
        state.onApplyRules(
            Rules.SqlDelightSource,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppCommonConfigKt,
            RemoveMarkedLine("SqlDelightSource"),
            RemoveMarkedLine("DatabaseSource")
        )
        state.onApplyRules(
            Rules.AppPlatformConfigKt,
            RemoveMarkedBlock("{dataflow.database.sqldelight}"),
            RemoveMarkedLine("sql"),
        )
    }

    private fun removePaging(state: TemplateState) {
        if (state.getFeature(MultiplatformPagingProcessor.ID) != null) return

        state.onApplyRules(
            Rules.AppBuildGradle,
            RemoveMarkedLine("sqldelight.androidx.paging"),
        )
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("sqldelight-androidx-paging")
            )
        )
    }

}