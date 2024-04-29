package core.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import core.ui.state.DataState
import core.ui.state.StoreState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.collections.set
import kotlin.coroutines.CoroutineContext
import kotlin.reflect.KClass

/**
 * Abstract class representing a ViewModel with lifecycle-aware coroutine launching capabilities.
 *
 * https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-lifecycle.html#viewmodel-implementation
 * https://github.com/Kotlin/kotlinx.coroutines/blob/master/ui/coroutines-guide-ui.md
 */
@Stable
@Immutable
abstract class BaseViewModel : ViewModel() {

    private val jobs = mutableMapOf<String, Job>()
    private var initialized = false

    /**
     * Launches a coroutine in the main thread context, managing the loading state and error handling.
     *
     * @param id The identifier for the coroutine job.
     * @param state The [StoreState] associated with the data state.
     * @param block The block of code to execute as a coroutine.
     */
    protected fun launchMain(
        id: String,
        state: StoreState? = null,
        block: suspend CoroutineScope.() -> Unit
    ) {
        launch(
            id = id,
            state = state,
            block = block,
            context = viewModelScope.coroutineContext,
        )
    }

    /**
     * Launches a coroutine in the IO thread context, managing the loading state and error handling.
     *
     * @param id The identifier for the coroutine job.
     * @param state The [StoreState] associated with the data state.
     * @param block The block of code to execute as a coroutine.
     */
    protected fun launchAsync(
        id: String,
        state: StoreState? = null,
        block: suspend CoroutineScope.() -> Unit
    ) {
        launch(
            id = id,
            state = state,
            block = block,
            context = Dispatchers.Default
        )
    }

    protected suspend fun <T> withAsync(block: suspend CoroutineScope.() -> T): Deferred<T> {
        return viewModelScope.async(Dispatchers.Default) { block.invoke(this) }
    }

    protected fun launch(
        id: String,
        state: StoreState?,
        context: CoroutineContext,
        block: suspend CoroutineScope.() -> Unit
    ) {
        jobs.remove(id)?.cancel()
        val loadingState = state?.let { DataState.Loading(id) }
        state?.dataStateStore?.set(loadingState)
        val job = viewModelScope.launch(context = context, block = block)
        if (state != null) {
            job.invokeOnCompletion { th ->
                val currentState = state.dataStateStore.get()
                if (currentState == null || currentState.uid == loadingState?.uid) {
                    val nextState = when {
                        th == null -> DataState.Loaded(id)
                        else -> DataState.Error(id, th)
                    }
                    state.dataStateStore.set(nextState)
                }
            }
        }
        jobs[id] = job
    }

    /**
     * Lifecycle-aware method called when binding the ViewModel to a [LifecycleOwner].
     *
     * @param owner The [LifecycleOwner] to bind to.
     */
    @Composable
    protected open fun doBind(owner: LifecycleOwner) = Unit

    /**
     * Lifecycle-aware method called when initializing the ViewModel.
     */
    protected open fun doInit() = Unit

    /**
     * Lifecycle-aware method called when binding the ViewModel to a view.
     */
    protected open fun doBind() = Unit

    /**
     * Lifecycle-aware method called when the ViewModel is resumed.
     */
    protected open fun doResume() = Unit

    /**
     * Lifecycle-aware method called when the ViewModel is paused.
     */
    protected open fun doPause() = Unit

    /**
     * Lifecycle-aware method called when disposing the ViewModel.
     */
    protected open fun doDispose() = Unit

    /**
     * Binds the ViewModel to the given [owner]'s lifecycle.
     *
     * @param owner The [LifecycleOwner] to bind to.
     */
    @Composable
    fun bind(owner: LifecycleOwner) {
        LaunchedEffect(owner) {
            val initial = !initialized
            initialized = true
            if (initial) {
                doInit()
            }
            doBind()
            var initialRequest = true
            owner.lifecycle.currentStateFlow.collect {
                when (it) {
                    Lifecycle.State.RESUMED -> {
                        if (!initialRequest) {
                            doResume()
                        }
                        initialRequest = false
                    }

                    Lifecycle.State.STARTED -> {
                        if (!initialRequest) {
                            doPause()
                        }
                    }

                    else -> Unit
                }
            }
        }
        doBind(owner)
    }

    override fun onCleared() {
        doDispose()
    }

}

@Stable
@Composable
fun <VM : BaseViewModel> provideViewModel(
    key: String? = null,
    modelClass: KClass<VM>,
    factory: ViewModelProvider.Factory
): VM {
    val storeOwner: ViewModelStoreOwner = LocalViewModelStoreOwner.current!!
    val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
    val viewModel = viewModel(
        modelClass = modelClass,
        viewModelStoreOwner = storeOwner,
        key = key,
        factory = factory,
    )
    viewModel.bind(lifecycleOwner)
    return viewModel
}

@Composable
fun ViewModelProvider(content: @Composable () -> Unit) {
    if (LocalViewModelStoreOwner.current != null) {
        content()
    } else {
        // TODO :: expected to be fixed in Compose Multiplatform 1.7.0
        CompositionLocalProvider(
            LocalViewModelStoreOwner provides rememberComposeViewModelStoreOwner(),
            content = content
        )
    }
}

@Composable
private fun rememberComposeViewModelStoreOwner(): ViewModelStoreOwner {
    val viewModelStoreOwner = remember { ComposeViewModelStoreOwner() }
    DisposableEffect(viewModelStoreOwner) {
        onDispose { viewModelStoreOwner.dispose() }
    }
    return viewModelStoreOwner
}

private class ComposeViewModelStoreOwner : ViewModelStoreOwner {
    override val viewModelStore = ViewModelStore()
    fun dispose() = viewModelStore.clear()
}