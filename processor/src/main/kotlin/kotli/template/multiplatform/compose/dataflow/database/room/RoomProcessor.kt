package kotli.template.multiplatform.compose.dataflow.database.room

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
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotli.template.multiplatform.compose.common.CommonKspProcessor
import kotli.template.multiplatform.compose.dataflow.database.SqliteProcessor
import kotli.template.multiplatform.compose.platform.client.MobileAndDesktopProcessor
import kotli.template.multiplatform.compose.platform.client.android.AndroidPlatformProcessor
import kotli.template.multiplatform.compose.platform.client.ios.IOSPlatformProcessor
import kotli.template.multiplatform.compose.platform.client.jvm.JvmPlatformProcessor
import kotli.template.multiplatform.compose.showcases.dataflow.database.room.RoomShowcasesProcessor
import kotlin.time.Duration.Companion.hours

object RoomProcessor : BaseFeatureProcessor() {

    const val ID = "dataflow.database.room"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.MobileAndDesktop
    override fun getIntegrationEstimate(state: TemplateState): Long = 4.hours.inWholeMilliseconds
    override fun getWebUrl(state: TemplateState): String =
        "https://developer.android.com/kotlin/multiplatform/room"

    override fun getIntegrationUrl(state: TemplateState): String =
        "https://developer.android.com/kotlin/multiplatform/room#defining-database"

    override fun canApply(state: TemplateState): Boolean {
        return listOfNotNull(
            state.getFeature(AndroidPlatformProcessor.ID),
            state.getFeature(IOSPlatformProcessor.ID),
            state.getFeature(JvmPlatformProcessor.ID)
        ).isNotEmpty()
    }

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        MobileAndDesktopProcessor::class.java,
        RoomShowcasesProcessor::class.java,
        CommonKspProcessor::class.java,
        SqliteProcessor::class.java,
    )

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.AppBuildGradle,
            CleanupMarkedBlock("{dataflow.database.room.config}"),
            CleanupMarkedLine("{dataflow.database.room}")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.AppBuildGradle,
            RemoveMarkedBlock("{dataflow.database.room.config}"),
            RemoveMarkedLine("{dataflow.database.room}")
        )
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("androidx-room")
            )
        )
        state.onApplyRules(
            Rules.RoomSource,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.RoomDir,
            RemoveFile()
        )
        state.onApplyRules(
            "app/schemas",
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppDiKt,
            RemoveMarkedLine("RoomSource")
        )
        state.onApplyRules(
            Rules.AppConfigureKoinKt,
            RemoveMarkedLine("RoomSource")
        )
    }

}