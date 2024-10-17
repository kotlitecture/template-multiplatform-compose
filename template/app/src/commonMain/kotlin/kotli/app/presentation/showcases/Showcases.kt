package kotli.app.presentation.showcases

import kotli.app.AppRoute
import kotli.app.presentation.showcases.dataflow.ai.gemini.GeminiShowcase
import kotli.app.presentation.showcases.dataflow.cache.basic.BasicCacheShowcase
import kotli.app.presentation.showcases.dataflow.encryption.BasicEncryptionShowcase
import kotli.app.presentation.showcases.dataflow.http.basic.BasicHttpShowcase
import kotli.app.presentation.showcases.dataflow.keyvalue.`object`.ObjectKeyValueShowcase
import kotli.app.presentation.showcases.dataflow.keyvalue.primitive.PrimitiveKeyValueShowcase
import kotli.app.presentation.showcases.dataflow.paging.basic.BasicPagingShowcase
import kotli.app.presentation.showcases.dataflow.room.crud.RoomCrudShowcase
import kotli.app.presentation.showcases.dataflow.sqldelight.crud.SqlDelightCrudShowcase
import kotli.app.presentation.showcases.dataflow.sqldelight.paging.SqlDelightPagingShowcase
import kotli.app.presentation.showcases.userflow.component.filepicker.FilePickerShowcase
import kotli.app.presentation.showcases.userflow.component.image.coil.CoilShowcase
import kotli.app.presentation.showcases.userflow.component.markdown.MarkdownShowcase
import kotli.app.presentation.showcases.userflow.component.placeholder.PlaceholderShowcase
import kotli.app.presentation.showcases.userflow.loader.data.DataLoaderShowcase
import kotli.app.presentation.showcases.userflow.navigation.args.ArgsNavigationShowcase
import kotli.app.presentation.showcases.userflow.navigation.no_args.NoArgsNavigationShowcase
import kotli.app.presentation.showcases.userflow.passcode.ResetPasscodeShowcase
import kotli.app.presentation.showcases.userflow.passcode.SetPasscodeShowcase
import kotli.app.presentation.showcases.userflow.theme.change.ChangeThemeDialogShowcase
import kotli.app.presentation.showcases.userflow.theme.change.ChangeThemeScreenShowcase
import kotli.app.presentation.showcases.userflow.theme.toggle.ToggleThemeShowcase
import kotlinx.serialization.Serializable

@Serializable
data class Showcases22(val id: String)

@Serializable
object Showcases : AppRoute {

    /**
     * A list containing all showcase items.
     */
    val all = listOf(
        ShowcaseItemGroup("Dataflow :: Cache"),
        BasicCacheShowcase,
        ShowcaseItemGroup("Dataflow :: Encryption"),
        BasicEncryptionShowcase,
        ShowcaseItemGroup("Dataflow :: Http"),
        BasicHttpShowcase,
        ShowcaseItemGroup("Dataflow :: KeyValue"),
        PrimitiveKeyValueShowcase,
        ObjectKeyValueShowcase,
        ShowcaseItemGroup("Dataflow :: Paging"),
        BasicPagingShowcase,
        ShowcaseItemGroup("Dataflow :: SqlDelight"),
        SqlDelightCrudShowcase,
        SqlDelightPagingShowcase,
        ShowcaseItemGroup("Dataflow :: Room"),
        RoomCrudShowcase,
        ShowcaseItemGroup("Dataflow :: AI"),
        GeminiShowcase,
        ShowcaseItemGroup("Userflow :: Navigation + MVVM"),
        NoArgsNavigationShowcase,
        ArgsNavigationShowcase,
        ShowcaseItemGroup("Userflow :: Loader"),
        DataLoaderShowcase,
        ShowcaseItemGroup("Userflow :: Theme"),
        ChangeThemeScreenShowcase,
        ChangeThemeDialogShowcase,
        ToggleThemeShowcase,
        ShowcaseItemGroup("Userflow :: Passcode"),
        SetPasscodeShowcase,
        ResetPasscodeShowcase,
        ShowcaseItemGroup("Userflow :: Design Components"),
        PlaceholderShowcase,
        CoilShowcase,
        MarkdownShowcase,
        FilePickerShowcase
    )

}