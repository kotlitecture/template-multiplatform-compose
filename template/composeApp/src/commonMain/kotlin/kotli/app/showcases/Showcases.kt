package kotli.app.showcases

import kotli.app.showcases.datasource.http.basic.BasicHttpShowcase
import kotli.app.showcases.datasource.keyvalue.`object`.ObjectKeyValueShowcase
import kotli.app.showcases.datasource.keyvalue.primitive.PrimitiveKeyValueShowcase
import kotli.app.showcases.datasource.paging.basic.BasicPagingShowcase
import kotli.app.showcases.navigation.args.ArgsNavigationShowcase
import kotli.app.showcases.navigation.no_args.NoArgsNavigationShowcase
import kotli.app.showcases.feature.loader.data.DataLoaderShowcase
import kotli.app.showcases.feature.theme.change.ChangeThemeDialogShowcase
import kotli.app.showcases.feature.theme.change.ChangeThemeScreenShowcase
import kotli.app.showcases.feature.theme.toggle.ToggleThemeShowcase

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
        ShowcaseItemGroup("Datasource :: Http"),
        BasicHttpShowcase,
        ShowcaseItemGroup("Datasource :: KeyValue"),
        PrimitiveKeyValueShowcase,
        ObjectKeyValueShowcase,
        ShowcaseItemGroup("Datasource :: Paging"),
        BasicPagingShowcase,
        ShowcaseItemGroup("Userflow :: Loader"),
        DataLoaderShowcase,
        ShowcaseItemGroup("Userflow :: Theme"),
        ChangeThemeScreenShowcase,
        ChangeThemeDialogShowcase,
        ToggleThemeShowcase
    )

}