package kotli.app.showcases.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotli.app.showcases.domain.Showcase
import kotli.app.showcases.presentation.dataflow.ai.gemini.GeminiRoute
import kotli.app.showcases.presentation.dataflow.cache.basic.BasicCacheRoute
import kotli.app.showcases.presentation.dataflow.encryption.BasicEncryptionRoute
import kotli.app.showcases.presentation.dataflow.http.basic.BasicHttpRoute
import kotli.app.showcases.presentation.dataflow.settings.`object`.ObjectSettingsRoute
import kotli.app.showcases.presentation.dataflow.settings.primitive.PrimitiveSettingsRoute
import kotli.app.showcases.presentation.dataflow.paging.basic.BasicPagingRoute
import kotli.app.showcases.presentation.dataflow.room.crud.RoomCrudRoute
import kotli.app.showcases.presentation.dataflow.sqldelight.crud.SqlDelightCrudRoute
import kotli.app.showcases.presentation.dataflow.sqldelight.paging.SqlDelightPagingRoute
import kotli.app.showcases.presentation.userflow.component.filepicker.FilePickerRoute
import kotli.app.showcases.presentation.userflow.component.image.coil.CoilRoute
import kotli.app.showcases.presentation.userflow.component.markdown.MarkdownRoute
import kotli.app.showcases.presentation.userflow.component.placeholder.PlaceholderRoute
import kotli.app.showcases.presentation.userflow.loader.advanced.AdvancedLoaderRoute
import kotli.app.showcases.presentation.userflow.loader.basic.BasicLoaderRoute
import kotli.app.showcases.presentation.userflow.passcode.PasscodeShowcases
import kotli.app.showcases.presentation.userflow.theme.change.ChangeThemeShowcases
import kotli.app.showcases.presentation.userflow.theme.toggle.ToggleThemeRoute
import shared.presentation.viewmodel.BaseViewModel

class ShowcasesViewModel : BaseViewModel() {

    private val showcases = listOf(
        Showcase.Header("Dataflow :: Cache"),
        BasicCacheRoute.screen,
        Showcase.Header("Dataflow :: Encryption"),
        BasicEncryptionRoute.screen,
        Showcase.Header("Dataflow :: Http"),
        BasicHttpRoute.screen,
        Showcase.Header("Dataflow :: Settings"),
        PrimitiveSettingsRoute.screen,
        ObjectSettingsRoute.screen,
        Showcase.Header("Dataflow :: Paging"),
        BasicPagingRoute.screen,
        Showcase.Header("Dataflow :: Room"),
        RoomCrudRoute.screen,
        Showcase.Header("Dataflow :: SqlDelight"),
        SqlDelightCrudRoute.screen,
        SqlDelightPagingRoute.screen,
        Showcase.Header("Dataflow :: AI"),
        GeminiRoute.screen,
        Showcase.Header("Userflow :: Loader"),
        BasicLoaderRoute.screen,
        AdvancedLoaderRoute.screen,
        Showcase.Header("Userflow :: Theme"),
        ChangeThemeShowcases.screen,
        ChangeThemeShowcases.dialog,
        ToggleThemeRoute.screen,
        Showcase.Header("Userflow :: Passcode"),
        PasscodeShowcases.set,
        PasscodeShowcases.reset,
        Showcase.Header("Userflow :: Design Components"),
        PlaceholderRoute.screen,
        FilePickerRoute.screen,
        MarkdownRoute.screen,
        CoilRoute.screen,
    )

    private val _state = ShowcasesMutableState(showcases)
    val state: ShowcasesState = _state

    fun onShowHint() {
        _state.showHint = true
    }

    fun onHideHint() {
        _state.showHint = false
    }

    private class ShowcasesMutableState(
        override val showcases: List<Showcase>
    ) : ShowcasesState {
        override var showHint: Boolean by mutableStateOf(false)
    }

}
