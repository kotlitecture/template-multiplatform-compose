package kotli.app.template.feature.presentation

import shared.presentation.state.MutableViewState
import shared.presentation.viewmodel.BaseViewModel

class TemplateViewModel : BaseViewModel() {

    private val _state = TemplateMutableState()
    val state: TemplateState = _state

    private class TemplateMutableState : MutableViewState(), TemplateState
}