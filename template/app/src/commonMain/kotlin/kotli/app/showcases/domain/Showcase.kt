package kotli.app.showcases.domain

sealed class Showcase(val label: String) {

    class Screen(label: String, val route: Any) : Showcase(label)

    class Header(label: String) : Showcase(label)

}