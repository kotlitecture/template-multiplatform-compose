package shared.design.icon

import template.shared.design.generated.resources.Res
import template.shared.design.generated.resources.ic_arrow_back
import template.shared.design.generated.resources.ic_cancel
import template.shared.design.generated.resources.ic_chevron_right
import template.shared.design.generated.resources.ic_coffee
import template.shared.design.generated.resources.ic_dark_mode
import template.shared.design.generated.resources.ic_info
import template.shared.design.generated.resources.ic_light_mode
import template.shared.design.generated.resources.ic_local_drink
import template.shared.design.generated.resources.ic_school
import template.shared.design.generated.resources.ic_wine_bar

interface AppIconsProvider {

    val info: AppIconModel
        get() = DrawableResourceIcon(Res.drawable.ic_info)
    val cancel: AppIconModel
        get() = DrawableResourceIcon(Res.drawable.ic_cancel)
    val arrowBack: AppIconModel
        get() = DrawableResourceIcon(Res.drawable.ic_arrow_back)
    val chevronRight: AppIconModel
        get() = DrawableResourceIcon(Res.drawable.ic_chevron_right)
    val lightMode: AppIconModel
        get() = DrawableResourceIcon(Res.drawable.ic_light_mode)
    val darkMode: AppIconModel
        get() = DrawableResourceIcon(Res.drawable.ic_dark_mode)
    val school: AppIconModel
        get() = DrawableResourceIcon(Res.drawable.ic_school)
    val coffee: AppIconModel
        get() = DrawableResourceIcon(Res.drawable.ic_coffee)
    val wineBar: AppIconModel
        get() = DrawableResourceIcon(Res.drawable.ic_wine_bar)
    val localDrink: AppIconModel
        get() = DrawableResourceIcon(Res.drawable.ic_local_drink)

}