package app.di.state

import app.ui.screen.template.TemplateDestination
import app.ui.screen.template_no_args.TemplateNoArgsDestination
import core.ui.navigation.NavigationState
import org.koin.dsl.module

val NavigationStateModule = module {
    single {
        NavigationState(
            destinations = listOf(
                TemplateNoArgsDestination,
                TemplateDestination
            )
        )
    }
}