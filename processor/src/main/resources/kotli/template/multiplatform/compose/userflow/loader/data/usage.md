## Overview

Component package: `app.common.presentation.loader`

If you need to modify the behavior, including colors, texts, logic, etc., simply update the `app.common.presentation.loader.LoaderDialog` composable.

## Example

```kotlin
@Composable
fun TemplateScreen() {
    val viewModel: TemplateViewModel = provideViewModel()
    val state = viewModel.state

    LaunchedEffect(state) {
        viewModel.onActionWithLoader()
    }

    LoaderDialog(isLoading = state::loading)
}

class TemplateViewModel() : BaseViewModel() {

    private val _state = TemplateMutableState()
    val state: TemplateState = _state
    
    fun onActionWithLoader() = async("Perform some action") {
        _state.loading = true
        delay(1000) // just delay to simulate an action
        _state.loading = false
    }
    
    private class TemplateMutableState : TemplateState {
        override var loading: Boolean by mutableStateOf(false)
    }
}
```