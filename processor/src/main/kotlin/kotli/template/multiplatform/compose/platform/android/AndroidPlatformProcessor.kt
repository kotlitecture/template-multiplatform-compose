package kotli.template.multiplatform.compose.platform.android

import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.platform.PlatformProcessor

object AndroidPlatformProcessor : PlatformProcessor() {

    const val ID = "platform.android"

    override fun getId(): String = ID

    override fun doRemove(state: TemplateState) {
        super.doRemove(state)
        state.onApplyRules(
            Rules.SrcAndroidMainDir,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.BuildGradleRoot,
            RemoveMarkedLine("android")
        )
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("agp"),
                RemoveMarkedLine("android-jvmTarget"),
                RemoveMarkedLine("android-compileSdk"),
                RemoveMarkedLine("android-minSdk"),
                RemoveMarkedLine("android-targetSdk"),
                RemoveMarkedLine("androidx-activity"),
                RemoveMarkedLine("androidx-appcompat"),
                RemoveMarkedLine("androidx-splashscreen"),
                RemoveMarkedLine("compose-android"),
            )
        )
    }

}