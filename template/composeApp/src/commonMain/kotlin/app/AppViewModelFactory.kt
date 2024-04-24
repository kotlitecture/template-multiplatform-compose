package app

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import app.di.instance
import app.showcases.ShowcasesViewModel
import app.ui.screen.template.TemplateViewModel
import app.ui.screen.template_no_args.TemplateNoArgsViewModel
import app.ui.theme.AppThemePersistenceViewModel
import app.ui.theme.AppThemeViewModel
import app.userflow.theme.change.ChangeThemeViewModel
import app.userflow.theme.toggle.ToggleThemeViewModel
import core.ui.BaseViewModel
import core.ui.provideViewModel
import kotlin.reflect.KClass

internal val AppViewModelFactory = viewModelFactory {
    initializer { instance<AppViewModel>() }
    initializer { instance<AppThemeViewModel>() }
    initializer { instance<AppThemePersistenceViewModel>() }
    initializer { instance<TemplateNoArgsViewModel>() }
    initializer { instance<TemplateViewModel>() }
    initializer { instance<ShowcasesViewModel>() }
    initializer { instance<ChangeThemeViewModel>() }
    initializer { instance<ToggleThemeViewModel>() }
}

@Composable
internal fun <VM : BaseViewModel> appViewModel(
    modelClass: KClass<VM>,
    key: String? = null,
): VM =
    provideViewModel(
        key = key,
        modelClass = modelClass,
        factory = AppViewModelFactory
    )