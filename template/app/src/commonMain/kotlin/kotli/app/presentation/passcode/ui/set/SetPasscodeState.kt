package kotli.app.presentation.passcode.ui.set

import org.jetbrains.compose.resources.StringResource
import template.app.generated.resources.Res
import template.app.generated.resources.passcode_set_confirm_new_title
import template.app.generated.resources.passcode_set_enter_new_title
import template.app.generated.resources.passcode_set_unlock_title

sealed class SetPasscodeState(open val titleRes: StringResource) {

    data class UnlockExisting(
        override val titleRes: StringResource = Res.string.passcode_set_unlock_title
    ) : SetPasscodeState(titleRes)

    data class EnterNew(
        override val titleRes: StringResource = Res.string.passcode_set_enter_new_title
    ) : SetPasscodeState(titleRes)

    data class ConfirmNew(
        override val titleRes: StringResource = Res.string.passcode_set_confirm_new_title,
        val code: String
    ) : SetPasscodeState(titleRes)

}
