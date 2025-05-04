package kotli.app.auth.signin.email.presentation

import kotlinx.serialization.Serializable

sealed interface SignInWithEmailRoute {

    @Serializable
    object Start : SignInWithEmailRoute

    @Serializable
    data class Verify(val email: String) : SignInWithEmailRoute
}