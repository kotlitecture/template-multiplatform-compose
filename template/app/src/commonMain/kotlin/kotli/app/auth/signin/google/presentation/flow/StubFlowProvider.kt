package kotli.app.auth.signin.google.presentation.flow

import androidx.compose.runtime.Composable
import kotli.app.auth.signin.google.domain.usecase.SignInWithGoogleUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class StubFlowProvider(
    private val signInWithGoogle: SignInWithGoogleUseCase,
) : GoogleFlowProvider {

    @Composable
    override fun provide(scope: CoroutineScope): GoogleFlow = GoogleFlow {
        scope.launch { signInWithGoogle.invoke() }
    }
}