package kotli.template.multiplatform.compose.userflow.passcode.basic

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.rule.CleanupMarkedLine
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.engine.template.rule.ReplaceMarkedText
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotli.template.multiplatform.compose.dataflow.encryption.korlibs.KorlibsEncryptionProcessor
import kotli.template.multiplatform.compose.dataflow.settings.datastore.DataStoreProcessor
import kotli.template.multiplatform.compose.dataflow.settings.multiplatform.MultiplatformSettingsProcessor
import kotli.template.multiplatform.compose.showcases.userflow.passcode.PasscodeShowcasesProcessor
import kotlin.reflect.KClass
import kotlin.time.Duration.Companion.hours

object BasicPasscodeProcessor : BaseFeatureProcessor() {

    const val ID = "userflow.passcode.basic"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getIntegrationEstimate(state: TemplateState): Long = 24.hours.inWholeMilliseconds

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        KorlibsEncryptionProcessor::class,
        MultiplatformSettingsProcessor::class,
        PasscodeShowcasesProcessor::class,
        DataStoreProcessor::class,
    )

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.AppKt,
            CleanupMarkedLine("{userflow.passcode.basic}")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.AppConfigKt,
            RemoveMarkedLine("passcode")
        )
        state.onApplyRules(
            Rules.AppPasscode,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.StringsXml,
            RemoveMarkedLine("passcode_")
        )
        state.onApplyRules(
            Rules.AppKt,
            RemoveMarkedLine("{userflow.passcode.basic}"),
            RemoveMarkedLine("PasscodeProvider"),
            ReplaceMarkedText(
                marker = "            ",
                text = "            ",
                replacer = "        "
            )
        )
    }

}