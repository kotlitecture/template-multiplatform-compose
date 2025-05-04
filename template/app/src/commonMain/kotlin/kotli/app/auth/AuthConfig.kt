package kotli.app.auth

import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import kotli.app.auth.common.authCommon
import kotli.app.auth.common.common
import kotli.app.auth.otp.otp
import kotli.app.auth.userflow.userFlow
import kotli.app.auth.signin.email.signInWithEmail
import kotli.app.auth.signin.google.signInWithGoogle
import kotli.app.auth.signout.signOut
import org.koin.dsl.module

fun NavGraphBuilder.auth(navController: NavHostController) {
    common(navController)
    otp(navController)
    signInWithEmail(navController)
    signInWithGoogle(navController)
    signOut(navController)
    userFlow(navController)
}

fun InitializerViewModelFactoryBuilder.auth() {
    common()
    otp()
    signInWithEmail()
    signInWithGoogle()
    signOut()
    userFlow()
}

val auth = module {
    includes(
        authCommon,
        otp,
        signInWithEmail,
        signInWithGoogle,
        signOut,
        userFlow,
    )
}
