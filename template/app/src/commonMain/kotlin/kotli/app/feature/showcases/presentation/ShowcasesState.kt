package kotli.app.feature.showcases.presentation

import androidx.compose.runtime.Stable
import kotli.app.feature.showcases.domain.Showcase

@Stable
interface ShowcasesState {

    val showHint: Boolean
    val showcases: List<Showcase>

}