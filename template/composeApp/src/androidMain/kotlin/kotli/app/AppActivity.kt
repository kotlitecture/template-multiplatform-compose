package kotli.app

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import kotli.app.di.instance
import shared.core.misc.extensions.findActivity
import shared.core.navigation.NavigationState
import shared.core.theme.ThemeState

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            App()
            EdgeToEdgeHandler(instance())
            SplashBlock(splashScreen, instance())
        }
    }
}

@Composable
private fun EdgeToEdgeHandler(state: ThemeState) {
    val activity = LocalContext.current.findActivity() ?: return
    val data = state.dataStore.asStateValue() ?: return
    val dark = data.context.dark
    val barStyle = remember(dark) {
        if (dark) {
            SystemBarStyle.dark(Color.TRANSPARENT)
        } else {
            SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT)
        }
    }
    LaunchedEffect(activity, barStyle) {
        activity.enableEdgeToEdge(
            statusBarStyle = barStyle,
            navigationBarStyle = barStyle
        )
    }
}

@Composable
private fun SplashBlock(splashScreen: SplashScreen, navigationState: NavigationState) {
    splashScreen.setKeepOnScreenCondition { navigationState.currentDestinationStore.isNull() }
}