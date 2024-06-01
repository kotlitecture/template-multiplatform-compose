package shared.design.icon

import androidx.compose.ui.res.painterResource
import shared.design.R

actual fun appIconsProvider() = object : AppIconsProvider {

    override val info: AppIconModel
        get() = PainterIcon { painterResource(R.drawable.ic_info) }
    override val cancel: AppIconModel
        get() = PainterIcon { painterResource(R.drawable.ic_cancel) }
    override val arrowBack: AppIconModel
        get() = PainterIcon { painterResource(R.drawable.ic_arrow_back) }
    override val chevronRight: AppIconModel
        get() = PainterIcon { painterResource(R.drawable.ic_chevron_right) }
    override val lightMode: AppIconModel
        get() = PainterIcon { painterResource(R.drawable.ic_light_mode) }
    override val darkMode: AppIconModel
        get() = PainterIcon { painterResource(R.drawable.ic_dark_mode) }
    override val school: AppIconModel
        get() = PainterIcon { painterResource(R.drawable.ic_school) }
    override val coffee: AppIconModel
        get() = PainterIcon { painterResource(R.drawable.ic_coffee) }
    override val wineBar: AppIconModel
        get() = PainterIcon { painterResource(R.drawable.ic_wine_bar) }
    override val localDrink: AppIconModel
        get() = PainterIcon { painterResource(R.drawable.ic_local_drink) }

}