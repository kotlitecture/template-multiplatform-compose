package kotli.template.multiplatform.compose

import kotli.engine.BaseTemplateProcessor
import kotli.engine.FeatureProvider
import kotli.engine.LayerType
import kotli.engine.TemplateState
import kotli.engine.model.LayerTypes
import kotli.engine.template.rule.ReplaceMarkedText

object MultiplatformComposeTemplateProcessor : BaseTemplateProcessor() {

    const val ID = "template-multiplatform-compose"

    override fun getId(): String = ID
    override fun getType(): LayerType = LayerTypes.Multiplatform
    override fun getWebUrl(): String = "https://github.com/kotlitecture/template-multiplatform-compose"

    override fun createProviders(): List<FeatureProvider> = listOf(

    )

    override fun processBefore(state: TemplateState) {
        state.onApplyRules(
            "app/build.gradle",
            ReplaceMarkedText(
                text = "kotli.app",
                marker = "{applicationId}",
                replacer = state.layer.namespace,
                singleLine = true
            )
        )
        state.onApplyRules(
            "app/src/main/res/values/strings.xml",
            ReplaceMarkedText(
                text = "My App",
                marker = "app_title",
                replacer = state.layer.name,
                singleLine = true
            )
        )
        state.onApplyRules(
            "settings.gradle",
            ReplaceMarkedText(
                text = "template",
                marker = "{projectName}",
                replacer = state.layer.name,
                singleLine = true
            )
        )
    }

}