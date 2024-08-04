package kotli.app.presentation.passcode.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import shared.design.component.AppIcon
import shared.design.component.AppText
import shared.design.icon.AppIconModel
import shared.design.icon.AppIcons
import shared.design.theme.AppTheme
import shared.presentation.store.DataState

private val numberSize = 48.sp
private val actionSize = 72.dp
private val actionSpace = 24.dp

/**
 * Composable function representing the passcode layout.
 *
 * @param modifier Modifier to be applied to the layout.
 * @param title Optional title for the passcode layout.
 * @param errorState State representing any error message to display.
 * @param codeState State representing the current passcode.
 * @param codeLength Length of the passcode.
 * @param onCodeChange Callback function invoked when the passcode changes.
 * @param bottomLeftBlock Composable block for the bottom left area of the layout.
 */
@Composable
fun PasscodeKeyboard(
    modifier: Modifier = Modifier,
    title: String? = null,
    codeState: DataState<String>,
    errorState: DataState<String>? = null,
    codeLength: Int,
    onCodeChange: (code: String) -> Unit,
    bottomLeftBlock: @Composable (size: Dp) -> Unit = {},
    bottomRightBlock: @Composable (size: Dp) -> Unit = {
        EraseBlock(codeState, onCodeChange)
    }
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(actionSpace, Alignment.CenterVertically)
    ) {
        PasscodeBlock(
            title = title,
            codeState = codeState,
            errorState = errorState,
            codeLength = codeLength
        )
        Row(horizontalArrangement = Arrangement.spacedBy(actionSpace)) {
            PadNumberButton(1, codeLength, codeState, onCodeChange)
            PadNumberButton(2, codeLength, codeState, onCodeChange)
            PadNumberButton(3, codeLength, codeState, onCodeChange)
        }
        Row(horizontalArrangement = Arrangement.spacedBy(actionSpace)) {
            PadNumberButton(4, codeLength, codeState, onCodeChange)
            PadNumberButton(5, codeLength, codeState, onCodeChange)
            PadNumberButton(6, codeLength, codeState, onCodeChange)
        }
        Row(horizontalArrangement = Arrangement.spacedBy(actionSpace)) {
            PadNumberButton(7, codeLength, codeState, onCodeChange)
            PadNumberButton(8, codeLength, codeState, onCodeChange)
            PadNumberButton(9, codeLength, codeState, onCodeChange)
        }
        Row(horizontalArrangement = Arrangement.spacedBy(actionSpace)) {
            Box(modifier = Modifier.size(actionSize)) {
                bottomLeftBlock(actionSize)
            }
            PadNumberButton(0, codeLength, codeState, onCodeChange)
            Box(modifier = Modifier.size(actionSize)) {
                bottomRightBlock(actionSize)
            }
        }
    }
}

@Composable
fun PadTextButton(
    text: String,
    onClick: () -> Unit
) {
    PadButton(
        onClick = onClick
    ) {
        AppText(
            text = text,
            maxLines = 1,
            fontSize = 16.sp,
            fontWeight = FontWeight.W500
        )
    }
}

@Composable
fun PadNumberButton(
    number: Int,
    codeLength: Int,
    codeState: DataState<String>,
    onCodeChange: (code: String) -> Unit
) {
    PadButton(
        backgroundColor = AppTheme.current.surface,
        onClick = {
            codeState.get().orEmpty()
                .let { code -> code + number }
                .takeIf { code -> code.length <= codeLength }
                ?.let(onCodeChange)
        }
    ) {
        AppText(
            text = number.toString(),
            fontSize = numberSize
        )
    }
}

@Composable
fun PadIconButton(
    modifier: Modifier = Modifier,
    icon: AppIconModel,
    onClick: () -> Unit
) {
    PadButton(
        onClick = onClick
    ) {
        AppIcon(
            modifier = modifier.size(32.dp),
            model = icon
        )
    }
}

@Composable
fun PadButton(
    backgroundColor: Color = Color.Unspecified,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .size(actionSize)
            .clip(RoundedCornerShape(percent = 50))
            .background(color = backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable(
                    onClick = onClick,
                    role = Role.Button,
                    interactionSource = remember { MutableInteractionSource() },
                    indication = LocalIndication.current
                )
        )
        content()
    }
}

@Composable
fun EraseBlock(codeState: DataState<String>, onCodeChange: (code: String) -> Unit) {
    Box(modifier = Modifier.size(actionSize)) {
        AnimatedVisibility(
            modifier = Modifier.size(actionSize),
            enter = scaleIn() + fadeIn(),
            exit = scaleOut() + fadeOut(),
            visible = !codeState.asStateValue().isNullOrEmpty()
        ) {
            PadIconButton(
                icon = AppIcons.backspace,
                onClick = {
                    codeState.get()
                        ?.takeIf { code -> code.isNotEmpty() }
                        ?.let { code -> code.take(code.length - 1) }
                        ?.let(onCodeChange)
                }
            )
        }
    }
}