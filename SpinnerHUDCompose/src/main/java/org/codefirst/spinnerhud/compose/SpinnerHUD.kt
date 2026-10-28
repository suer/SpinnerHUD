package org.codefirst.spinnerhud.compose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import kotlinx.coroutines.delay
import kotlin.math.cos
import kotlin.math.sin
import kotlin.time.DurationUnit
import kotlin.time.toDuration

private const val BAR_COUNT = 12
private const val STEP_DEGREE = 360f / BAR_COUNT
private const val FRAME_TIME_MILLIS = 1000L / 12
private const val DIM_AMOUNT = 0.5f
private val BackgroundColor = Color(0xB1000000)

@Composable
fun SpinnerHUD(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    label: String = "",
    cancellable: Boolean = false,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties =
            DialogProperties(
                dismissOnBackPress = cancellable,
                dismissOnClickOutside = false,
            ),
    ) {
        val dialogWindow = (LocalView.current.parent as? DialogWindowProvider)?.window
        SideEffect { dialogWindow?.setDimAmount(DIM_AMOUNT) }
        Column(
            modifier =
                modifier
                    .background(BackgroundColor, RoundedCornerShape(10.dp))
                    .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spinner(Modifier.size(52.dp))
            if (label.isNotBlank()) {
                BasicText(
                    text = label,
                    modifier = Modifier.padding(top = 8.dp),
                    style = TextStyle(color = Color.White, fontSize = 16.sp),
                )
            }
        }
    }
}

@Composable
fun Spinner(modifier: Modifier = Modifier) {
    var step by remember { mutableIntStateOf(0) }
    LaunchedEffect(Unit) {
        while (true) {
            delay(FRAME_TIME_MILLIS.toDuration(DurationUnit.MILLISECONDS))
            step = (step + 1) % BAR_COUNT
        }
    }

    Canvas(modifier) {
        val center = Offset(size.width / 2, size.height / 2)
        val outer = size.minDimension / 2
        val strokeWidth = outer * 0.154f
        val innerRadius = outer / 2 + strokeWidth / 2
        val outerRadius = outer - strokeWidth / 2
        rotate(step * STEP_DEGREE, center) {
            for (i in 0 until BAR_COUNT) {
                val radian = Math.toRadians((i * STEP_DEGREE).toDouble())
                val dx = sin(radian).toFloat()
                val dy = -cos(radian).toFloat()
                drawLine(
                    color = Color.White.copy(alpha = 1f - 0.06f * i),
                    start = center + Offset(dx * innerRadius, dy * innerRadius),
                    end = center + Offset(dx * outerRadius, dy * outerRadius),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round,
                )
            }
        }
    }
}
