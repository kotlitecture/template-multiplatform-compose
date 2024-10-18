package kotli.app.feature.showcases

import kotli.app.AppRoute
import kotli.app.feature.showcases.dataflow.ai.gemini.GeminiShowcase
import kotli.app.feature.showcases.dataflow.cache.basic.BasicCacheShowcase
import kotli.app.feature.showcases.dataflow.encryption.BasicEncryptionShowcase
import kotli.app.feature.showcases.dataflow.http.basic.BasicHttpShowcase
import kotli.app.feature.showcases.dataflow.keyvalue.`object`.ObjectKeyValueShowcase
import kotli.app.feature.showcases.dataflow.keyvalue.primitive.PrimitiveKeyValueShowcase
import kotli.app.feature.showcases.dataflow.paging.basic.BasicPagingShowcase
import kotli.app.feature.showcases.dataflow.room.crud.RoomCrudShowcase
import kotli.app.feature.showcases.dataflow.sqldelight.crud.SqlDelightCrudShowcase
import kotli.app.feature.showcases.dataflow.sqldelight.paging.SqlDelightPagingShowcase
import kotli.app.feature.showcases.userflow.component.filepicker.FilePickerShowcase
import kotli.app.feature.showcases.userflow.component.image.coil.CoilShowcase
import kotli.app.feature.showcases.userflow.component.markdown.MarkdownShowcase
import kotli.app.feature.showcases.userflow.component.placeholder.PlaceholderShowcase
import kotli.app.feature.showcases.userflow.loader.data.DataLoaderShowcase
import kotli.app.feature.showcases.userflow.navigation.args.ArgsNavigationShowcase
import kotli.app.feature.showcases.userflow.navigation.no_args.NoArgsNavigationShowcase
import kotli.app.feature.showcases.userflow.passcode.ResetPasscodeShowcase
import kotli.app.feature.showcases.userflow.passcode.SetPasscodeShowcase
import kotli.app.feature.showcases.userflow.theme.change.ChangeThemeDialogShowcase
import kotli.app.feature.showcases.userflow.theme.change.ChangeThemeScreenShowcase
import kotli.app.feature.showcases.userflow.theme.toggle.ToggleThemeShowcase
import kotlinx.serialization.Serializable

@Serializable
object ShowcasesRoute : AppRoute {

    val all = listOf(
        kotli.app.feature.showcases.ShowcaseItemGroup("Dataflow :: Cache"),
        BasicCacheShowcase,
        kotli.app.feature.showcases.ShowcaseItemGroup("Dataflow :: Encryption"),
        BasicEncryptionShowcase,
        kotli.app.feature.showcases.ShowcaseItemGroup("Dataflow :: Http"),
        BasicHttpShowcase,
        kotli.app.feature.showcases.ShowcaseItemGroup("Dataflow :: KeyValue"),
        PrimitiveKeyValueShowcase,
        ObjectKeyValueShowcase,
        kotli.app.feature.showcases.ShowcaseItemGroup("Dataflow :: Paging"),
        BasicPagingShowcase,
        kotli.app.feature.showcases.ShowcaseItemGroup("Dataflow :: SqlDelight"),
        SqlDelightCrudShowcase,
        SqlDelightPagingShowcase,
        kotli.app.feature.showcases.ShowcaseItemGroup("Dataflow :: Room"),
        RoomCrudShowcase,
        kotli.app.feature.showcases.ShowcaseItemGroup("Dataflow :: AI"),
        GeminiShowcase,
        kotli.app.feature.showcases.ShowcaseItemGroup("Userflow :: Navigation + MVVM"),
        NoArgsNavigationShowcase,
        ArgsNavigationShowcase,
        kotli.app.feature.showcases.ShowcaseItemGroup("Userflow :: Loader"),
        DataLoaderShowcase,
        kotli.app.feature.showcases.ShowcaseItemGroup("Userflow :: Theme"),
        ChangeThemeScreenShowcase,
        ChangeThemeDialogShowcase,
        ToggleThemeShowcase,
        kotli.app.feature.showcases.ShowcaseItemGroup("Userflow :: Passcode"),
        SetPasscodeShowcase,
        ResetPasscodeShowcase,
        kotli.app.feature.showcases.ShowcaseItemGroup("Userflow :: Design Components"),
        PlaceholderShowcase,
        CoilShowcase,
        MarkdownShowcase,
        FilePickerShowcase
    )

}