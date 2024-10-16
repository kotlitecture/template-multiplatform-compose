package shared.presentation.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.collections.set
import kotlin.coroutines.CoroutineContext

/**
 * Abstract class representing a ViewModel with lifecycle-aware coroutine launching capabilities.
 *
 * https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-lifecycle.html#viewmodel-implementation
 * https://github.com/Kotlin/kotlinx.coroutines/blob/master/ui/coroutines-guide-ui.md
 */
@Immutable
abstract class BaseViewModel : ViewModel() {

    private val jobs = mutableMapOf<String, Job>()
    private var initialized = false

    /**
     * Launches a coroutine in the main thread context, managing the loading state and error handling.
     *
     * @param id The identifier for the coroutine job.
     * @param block The block of code to execute as a coroutine.
     */
    protected fun launchUI(
        id: String,
        block: suspend CoroutineScope.() -> Unit
    ) {
        launch(
            id = id,
            block = block,
            context = Dispatchers.Main.immediate,
        )
    }

    /**
     * Launches a coroutine in the IO thread context, managing the loading state and error handling.
     *
     * @param id The identifier for the coroutine job.
     * @param force Force new execution despite any existing is in progress.
     * @param block The block of code to execute as a coroutine.
     */
    protected fun launchAsync(
        id: String,
        force: Boolean = false,
        block: suspend CoroutineScope.() -> Unit
    ) {
        launch(
            id = id,
            force = force,
            block = block,
            context = Dispatchers.Default
        )
    }

    protected suspend fun <T> withAsync(block: suspend CoroutineScope.() -> T): Deferred<T> {
        return viewModelScope.async(Dispatchers.Default) { block.invoke(this) }
    }

    private fun launch(
        id: String,
        force: Boolean = false,
        context: CoroutineContext,
        block: suspend CoroutineScope.() -> Unit
    ) {
        val job = jobs[id]
        when {
            force -> {
                job?.cancel()
                jobs[id] = viewModelScope.launch(context = context, block = block)
            }

            job == null || job.isCompleted -> {
                jobs[id] = viewModelScope.launch(context = context, block = block)
            }

            else -> Unit
        }
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
     * Binds the ViewModel to the current Composable lifecycle.
     */
    @Composable
    fun bind() {
        val owner = LocalLifecycleOwner.current
        LaunchedEffect(owner) {
            val initial = !initialized
            initialized = true
            if (initial) {
                doInit()
            }
            doBind()
            var initialRequest = true
            owner.lifecycle.currentStateFlow.collect { state ->
                when (state) {
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
inline fun <reified VM : BaseViewModel> provideViewModel(
    key: String? = null,
    factory: ViewModelProvider.Factory = LocalViewModelFactory.current
): VM {
    val viewModel: VM = viewModel(key = key, factory = factory)
    viewModel.bind()
    return viewModel
}