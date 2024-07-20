package kotli.app.presentation.showcases

import kotli.app.presentation.showcases.dataflow.cache.basic.BasicCacheShowcase
import kotli.app.presentation.showcases.dataflow.http.basic.BasicHttpShowcase
import kotli.app.presentation.showcases.dataflow.keyvalue.`object`.ObjectKeyValueShowcase
import kotli.app.presentation.showcases.dataflow.keyvalue.primitive.PrimitiveKeyValueShowcase
import kotli.app.presentation.showcases.dataflow.paging.basic.BasicPagingShowcase
import kotli.app.presentation.showcases.dataflow.room.crud.RoomCrudShowcase
import kotli.app.presentation.showcases.dataflow.sqldelight.crud.SqlDelightCrudShowcase
import kotli.app.presentation.showcases.dataflow.sqldelight.paging.SqlDelightPagingShowcase
import kotli.app.presentation.showcases.userflow.component.placeholder.PlaceholderShowcase
import kotli.app.presentation.showcases.userflow.loader.data.DataLoaderShowcase
import kotli.app.presentation.showcases.userflow.theme.change.ChangeThemeDialogShowcase
import kotli.app.presentation.showcases.userflow.theme.change.ChangeThemeScreenShowcase
import kotli.app.presentation.showcases.userflow.theme.toggle.ToggleThemeShowcase
import kotli.app.presentation.showcases.userflow.navigation.args.ArgsNavigationShowcase
import kotli.app.presentation.showcases.userflow.navigation.no_args.NoArgsNavigationShowcase

/**
 * Object containing all showcase items.
 */
object Showcases {

    /**
     * A list containing all showcase items.
     */
    val all = listOf(
        ShowcaseItemGroup("Dataflow :: Cache"),
        BasicCacheShowcase,
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
        ShowcaseItemGroup("Userflow :: Navigation + MVVM"),
        NoArgsNavigationShowcase,
        ArgsNavigationShowcase,
        ShowcaseItemGroup("Userflow :: Loader"),
        DataLoaderShowcase,
        ShowcaseItemGroup("Userflow :: Theme"),
        ChangeThemeScreenShowcase,
        ChangeThemeDialogShowcase,
        ToggleThemeShowcase,
        ShowcaseItemGroup("Userflow :: Components"),
        PlaceholderShowcase
    )

}