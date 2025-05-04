package kotli.app.auth.signin.google.presentation.flow

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import io.github.jan.supabase.compose.auth.composable.rememberSignInWithGoogle
import io.github.jan.supabase.compose.auth.composeAuth
import kotli.app.auth.signin.google.domain.usecase.SignInWithGoogleUseCase
import kotli.app.common.data.source.supabase.SupabaseSource
import kotlinx.coroutines.CoroutineScope

class SupabaseFlowProvider(
    private val signInWithGoogle: SignInWithGoogleUseCase,
    private val supabase: SupabaseSource
) : GoogleFlowProvider {

    @Stable
    @Composable
    override fun provide(scope: CoroutineScope): GoogleFlow {
        val action = supabase.client.composeAuth.rememberSignInWithGoogle(
            fallback = signInWithGoogle::invoke
        )
        return GoogleFlow { action.startFlow() }
    }
}