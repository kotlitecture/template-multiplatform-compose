package kotli.template.multiplatform.compose.platform.backend

import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.platform.PlatformProcessor
import kotli.template.multiplatform.compose.platform.shared.SharedDomainProcessor

object BackendPlatformProcessor : PlatformProcessor() {

    const val ID = "platform.backend"

    override fun getId(): String = ID

    override fun dependencies(): List<Class<out FeatureProcessor>> = listOf(
        SharedDomainProcessor::class.java
    )

    override fun doRemove(state: TemplateState) {
        super.doRemove(state)
        state.onApplyRules(
            Rules.BackendDir,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.BuildGradleRoot,
            RemoveMarkedLine("kotlin.jvm")
        )
        state.onApplyRules(
            Rules.SettingsGradle,
            RemoveMarkedLine("backend")
        )
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("logback"),
                RemoveMarkedLine("server"),
                RemoveMarkedLine("kotlin.jvm"),
                RemoveMarkedLine("ktor.plugin")
            )
        )
    }

}