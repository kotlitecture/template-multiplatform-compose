package shared.presentation.ui.component.scrollbar

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.awaitHorizontalDragOrCancellation
import androidx.compose.foundation.gestures.awaitVerticalDragOrCancellation
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.PointerInputScope
import androidx.compose.ui.input.pointer.pointerInput
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal fun Modifier.scrollOnPressTrack(
    isVertical: Boolean,
    reverseLayout: Boolean,
    sliderAdapter: SliderAdapter,
): Modifier = composed {
    val coroutineScope = rememberCoroutineScope()
    val scroller = remember(sliderAdapter, coroutineScope, reverseLayout) {
        TrackPressScroller(coroutineScope, sliderAdapter, reverseLayout)
    }

    pointerInput(scroller) {
        detectScrollViaTrackGestures(
            isVertical = isVertical,
            scroller = scroller
        )
    }
}

/**
 * Responsible for scrolling when the scrollbar track is pressed (outside the thumb).
 */
private class TrackPressScroller(
    private val coroutineScope: CoroutineScope,
    private val sliderAdapter: SliderAdapter,
    private val reverseLayout: Boolean,
) {

    /**
     * The current direction of scroll (1: down/right, -1: up/left, 0: not scrolling)
     */
    private var direction = 0

    /**
     * The currently pressed location (in pixels) on the scrollable axis.
     */
    private var offset: Float? = null

    /**
     * The job that keeps scrolling while the track is pressed.
     */
    private var job: Job? = null

    /**
     * Calculates the direction of scrolling towards the given offset (in pixels).
     */
    private fun directionOfScrollTowards(offset: Float): Int {
        val pixelRange = sliderAdapter.thumbPixelRange
        return when {
            offset < pixelRange.first -> if (reverseLayout) 1 else -1
            offset > pixelRange.last -> if (reverseLayout) -1 else 1
            else -> 0
        }
    }

    /**
     * Scrolls once towards the current offset, if it matches the direction of the current gesture.
     */
    private suspend fun scrollTowardsCurrentOffset() {
        offset?.let {
            val currentDirection = directionOfScrollTowards(it)
            if (currentDirection != direction)
                return
            with(sliderAdapter.adapter) {
                scrollTo(scrollOffset + currentDirection * viewportSize)
            }
        }
    }

    /**
     * Starts the job that scrolls continuously towards the current offset.
     */
    private fun startScrolling() {
        job?.cancel()
        job = coroutineScope.launch {
            scrollTowardsCurrentOffset()
            delay(DelayBeforeSecondScrollOnTrackPress)
            while (true) {
                scrollTowardsCurrentOffset()
                delay(DelayBetweenScrollsOnTrackPress)
            }
        }
    }

    /**
     * Invoked on the first press for a gesture.
     */
    fun onPress(offset: Float) {
        this.offset = offset
        this.direction = directionOfScrollTowards(offset)

        if (direction != 0)
            startScrolling()
    }

    /**
     * Invoked when the pointer moves while pressed during the gesture.
     */
    fun onMovePressed(offset: Float) {
        this.offset = offset
    }

    /**
     * Cleans up when the gesture finishes.
     */
    private fun cleanupAfterGesture() {
        job?.cancel()
        direction = 0
        offset = null
    }

    /**
     * Invoked when the button is released.
     */
    fun onRelease() {
        cleanupAfterGesture()
    }

    /**
     * Invoked when the gesture is cancelled.
     */
    fun onGestureCancelled() {
        cleanupAfterGesture()
        // Maybe revert to the initial position?
    }

}

/**
 * Detects the pointer events relevant for the "scroll by pressing on the track outside the thumb"
 * gesture and calls the corresponding methods in the [scroller].
 */
private suspend fun PointerInputScope.detectScrollViaTrackGestures(
    isVertical: Boolean,
    scroller: TrackPressScroller,
) {
    fun Offset.onScrollAxis() = if (isVertical) y else x

    awaitEachGesture {
        val down = awaitFirstDown()
        scroller.onPress(down.position.onScrollAxis())

        while (true) {
            val drag =
                if (isVertical)
                    awaitVerticalDragOrCancellation(down.id)
                else
                    awaitHorizontalDragOrCancellation(down.id)

            if (drag == null) {
                scroller.onGestureCancelled()
                break
            } else if (!drag.pressed) {
                scroller.onRelease()
                break
            } else
                scroller.onMovePressed(drag.position.onScrollAxis())
        }
    }
}

/**
 * The delay between the 1st and 2nd scroll while the scrollbar track is pressed outside the thumb.
 */
private const val DelayBeforeSecondScrollOnTrackPress: Long = 300L

/**
 * The delay between each subsequent (after the 2nd) scroll while the scrollbar track is pressed
 * outside the thumb.
 */
private const val DelayBetweenScrollsOnTrackPress: Long = 100L
