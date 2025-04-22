package kotli.app.showcases.presentation.userflow.auth

import kotli.app.auth.userflow.presentation.basic.BasicAuthRoute
import kotli.app.showcases.domain.Showcase

object AuthShowcases {

    val basic = Showcase.Screen("Basic Auth Flow", BasicAuthRoute("Basic Auth Flow"))

}