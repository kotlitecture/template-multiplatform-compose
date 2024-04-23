package app.di.state

import app.ui.screen.template_no_args.TemplateDestination
import core.ui.navigation.NavigationState
import org.koin.dsl.module

val NavigationStateModule = module {
    single {
        NavigationState(
            destinations = listOf(
                TemplateDestination
            )
        )
    }
}