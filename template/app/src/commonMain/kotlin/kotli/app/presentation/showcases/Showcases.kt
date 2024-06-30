package kotli.app.presentation.showcases

import kotli.app.presentation.showcases.datasource.cache.basic.BasicCacheShowcase
import kotli.app.presentation.showcases.datasource.http.basic.BasicHttpShowcase
import kotli.app.presentation.showcases.datasource.keyvalue.`object`.ObjectKeyValueShowcase
import kotli.app.presentation.showcases.datasource.keyvalue.primitive.PrimitiveKeyValueShowcase
import kotli.app.presentation.showcases.datasource.paging.basic.BasicPagingShowcase
import kotli.app.presentation.showcases.datasource.sqldelight.crud.SqlDelightCrudShowcase
import kotli.app.presentation.showcases.datasource.sqldelight.paging.SqlDelightPagingShowcase
import kotli.app.presentation.showcases.feature.loader.data.DataLoaderShowcase
import kotli.app.presentation.showcases.feature.theme.change.ChangeThemeDialogShowcase
import kotli.app.presentation.showcases.feature.theme.change.ChangeThemeScreenShowcase
import kotli.app.presentation.showcases.feature.theme.toggle.ToggleThemeShowcase
import kotli.app.presentation.showcases.navigation.args.ArgsNavigationShowcase
import kotli.app.presentation.showcases.navigation.no_args.NoArgsNavigationShowcase

/**
 * Object containing all showcase items.
 */
object Showcases {

    /**
     * A list containing all showcase items.
     */
    val all = listOf(
        ShowcaseItemGroup("Navigation + MVVM"),
        NoArgsNavigationShowcase,
        ArgsNavigationShowcase,
        ShowcaseItemGroup("Datasource :: Cache"),
        BasicCacheShowcase,
        ShowcaseItemGroup("Datasource :: Http"),
        BasicHttpShowcase,
        ShowcaseItemGroup("Datasource :: KeyValue"),
        PrimitiveKeyValueShowcase,
        ObjectKeyValueShowcase,
        ShowcaseItemGroup("Datasource :: Paging"),
        BasicPagingShowcase,
        ShowcaseItemGroup("Datasource :: SqlDelight"),
        SqlDelightCrudShowcase,
        SqlDelightPagingShowcase,
        ShowcaseItemGroup("Userflow :: Loader"),
        DataLoaderShowcase,
        ShowcaseItemGroup("Userflow :: Theme"),
        ChangeThemeScreenShowcase,
        ChangeThemeDialogShowcase,
        ToggleThemeShowcase
    )

}