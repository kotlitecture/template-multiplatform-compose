package kotli.app.feature.showcases.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotli.app.feature.showcases.domain.Showcase
import kotli.app.feature.showcases.presentation.dataflow.ai.gemini.GeminiRoute
import kotli.app.feature.showcases.presentation.dataflow.cache.basic.BasicCacheRoute
import kotli.app.feature.showcases.presentation.dataflow.encryption.BasicEncryptionRoute
import kotli.app.feature.showcases.presentation.dataflow.http.basic.BasicHttpRoute
import kotli.app.feature.showcases.presentation.dataflow.keyvalue.`object`.ObjectKeyValueRoute
import kotli.app.feature.showcases.presentation.dataflow.keyvalue.primitive.PrimitiveKeyValueRoute
import kotli.app.feature.showcases.presentation.userflow.component.filepicker.FilePickerRoute
import kotli.app.feature.showcases.presentation.userflow.component.image.coil.CoilRoute
import kotli.app.feature.showcases.presentation.userflow.component.markdown.MarkdownRoute
import kotli.app.feature.showcases.presentation.userflow.component.placeholder.PlaceholderRoute
import kotli.app.feature.showcases.presentation.userflow.loader.LoaderRoute
import kotli.app.feature.showcases.presentation.userflow.passcode.ResetPasscodeRoute
import kotli.app.feature.showcases.presentation.userflow.passcode.SetPasscodeRoute
import kotli.app.feature.showcases.presentation.userflow.theme.change.ChangeThemeDialogRoute
import kotli.app.feature.showcases.presentation.userflow.theme.change.ChangeThemeScreenRoute
import kotli.app.feature.showcases.presentation.userflow.theme.toggle.ToggleThemeRoute
import shared.presentation.viewmodel.BaseViewModel

class ShowcasesViewModel : BaseViewModel() {

    private val showcases = listOf(
        Showcase.Header("Dataflow :: Cache"),
        BasicCacheRoute.screen,
        Showcase.Header("Dataflow :: Encryption"),
        BasicEncryptionRoute.screen,
        Showcase.Header("Dataflow :: Http"),
        BasicHttpRoute.screen,
        Showcase.Header("Dataflow :: KeyValue"),
        PrimitiveKeyValueRoute.screen,
        ObjectKeyValueRoute.screen,
        Showcase.Header("Dataflow :: Paging"),
        BasicPagingShowcase,
        Showcase.Header("Dataflow :: SqlDelight"),
        SqlDelightCrudShowcase,
        SqlDelightPagingShowcase,
        Showcase.Header("Dataflow :: Room"),
        RoomCrudShowcase,
        Showcase.Header("Dataflow :: AI"),
        GeminiRoute.screen,
        Showcase.Header("Userflow :: Loader"),
        LoaderRoute.screen,
        Showcase.Header("Userflow :: Theme"),
        ChangeThemeScreenRoute.screen,
        ChangeThemeDialogRoute.screen,
        ToggleThemeRoute.screen,
        Showcase.Header("Userflow :: Passcode"),
        SetPasscodeRoute.screen,
        ResetPasscodeRoute.screen,
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
