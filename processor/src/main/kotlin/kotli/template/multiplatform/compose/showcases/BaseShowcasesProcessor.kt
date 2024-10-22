package kotli.template.multiplatform.compose.showcases

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules

abstract class BaseShowcasesProcessor : BaseFeatureProcessor() {

    final override fun isInternal(): Boolean = true

    protected fun removeDir(state: TemplateState, name: String) {
        state.onApplyRules(name, RemoveFile())
    }

    protected fun removeFromConfig(state: TemplateState, vararg names: String) {
        state.onApplyRules(
            Rules.AppShowcasesConfigKt,
            *names.map { RemoveMarkedLine(it) }.toTypedArray()
        )
    }

    protected fun removeFromViewModel(state: TemplateState, vararg names: String) {
        state.onApplyRules(
            Rules.AppShowcasesViewModelKt,
            *names.map { RemoveMarkedLine(it) }.toTypedArray()
        )
    }

}