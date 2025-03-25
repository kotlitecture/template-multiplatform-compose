package kotli.app.showcases.presentation

import androidx.compose.runtime.Stable
import kotli.app.showcases.domain.Showcase

@Stable
interface ShowcasesState {

    val showHint: Boolean
    val showcases: List<Showcase>

}