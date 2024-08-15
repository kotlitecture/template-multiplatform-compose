package kotli.template.multiplatform.compose.userflow.component.image.coil

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
import kotli.template.multiplatform.compose.userflow.component.ComponentProcessor
import kotlin.time.Duration.Companion.hours

object CoilProcessor : BaseFeatureProcessor() {

    const val ID = "userflow.component.image.coil"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getIntegrationEstimate(state: TemplateState): Long = 1.hours.inWholeMilliseconds
    override fun getWebUrl(state: TemplateState): String = "https://coil-kt.github.io/coil/"
    override fun getIntegrationUrl(state: TemplateState): String = "https://coil-kt.github.io/coil/upgrading_to_coil3/#multiplatform"

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        ComponentProcessor::class.java
    )

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.AppIcon,
            CleanupMarkedBlock("{userflow.coil}")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.BuildGradleSharedDesign,
            RemoveMarkedLine("coil")
        )

        state.onApplyRules(
            Rules.AppIcon,
            RemoveMarkedBlock("{userflow.coil}"),
            RemoveMarkedLine("UrlModel"),
            RemoveMarkedLine("coil"),
        )

        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("coil")
            )
        )

        state.onApplyRules(
            Rules.AppModuleKt,
            RemoveMarkedLine("CoilShowcaseViewModel")
        )

        state.onApplyRules(
            Rules.ShowcasesCoilDir,
            RemoveFile()
        )

        state.onApplyRules(
            Rules.ShowcasesKt,
            RemoveMarkedLine("CoilShowcase")
        )
    }

}