package kotli.template.multiplatform.compose.platform.server.supabase

import kotli.engine.FeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.model.FeatureTags
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.CleanupMarkedBlock
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedBlock
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.dataflow.common.CommonDataFlowProcessor
import kotli.template.multiplatform.compose.dataflow.http.ktor.KtorHttpProcessor
import kotli.template.multiplatform.compose.platform.PlatformProcessor
import kotlin.reflect.KClass
import kotlin.time.Duration.Companion.hours

object SupabaseProcessor : PlatformProcessor() {

    const val ID = "platform.server.supabase"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = listOf(FeatureTags.Server, FeatureTags.Client)
    override fun getWebUrl(state: TemplateState): String = "https://supabase.com"
    override fun getIntegrationUrl(state: TemplateState): String = "https://supabase.com/docs"
    override fun getIntegrationEstimate(state: TemplateState): Long = 16.hours.inWholeMilliseconds
    override fun getConfigurationEstimate(state: TemplateState): Long = 4.hours.inWholeMilliseconds

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        CommonDataFlowProcessor::class,
        KtorHttpProcessor::class
    )

    override fun doApply(state: TemplateState) {
        super.doApply(state)
        state.onApplyRules(
            Rules.AppCommonConfigKt,
            CleanupMarkedBlock("{supabase}")
        )
        state.onApplyRules(
            Rules.AppAuthCommonConfigKt,
            RemoveMarkedLine("stub")
        )
        state.onApplyRules(
            Rules.AppAuthSignInWithGoogleConfigKt,
            RemoveMarkedLine("stub")
        )
        state.onApplyRules(
            "${Rules.AppAuthSignInWithGoogleDir}/presentation/flow/StubFlowProvider.kt",
            RemoveFile()
        )
    }

    override fun doRemove(state: TemplateState) {
        super.doRemove(state)
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("supabase"),
            )
        )
        state.onApplyRules(
            Rules.BuildGradle,
            RemoveMarkedLine("supabase")
        )
        state.onApplyRules(
            Rules.SupabaseSource,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.AppCommonConfigKt,
            RemoveMarkedBlock("{supabase}"),
            RemoveMarkedLine("supabase")
        )
        state.onApplyRules(
            Rules.AppAuthCommonConfigKt,
            RemoveMarkedLine("supabase")
        )
        state.onApplyRules(
            Rules.AppAuthSignInWithGoogleConfigKt,
            RemoveMarkedLine("supabase")
        )
        state.onApplyRules(
            "${Rules.AppAuthSignInWithGoogleDir}/presentation/flow/SupabaseFlowProvider.kt",
            RemoveFile()
        )
    }
}