package org.codefirst.spinnerhud

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class SpinnerView : AppCompatImageView {
    companion object {
        private const val STEP_DEGREE: Float = 30f
        private const val FRAME_TIME: Long = 1000 / 12
    }

    var currentDegree = 0f
    var attached = false
    var runnable: Runnable? = null

    constructor(context: Context) : super(context) {
        initialize()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initialize()
    }

    private fun initialize() {
        setImageResource(R.drawable.spinner)
        runnable = object : Runnable {
            override fun run() {
                currentDegree += STEP_DEGREE
                currentDegree = if (currentDegree < 360) currentDegree else currentDegree - 360
                invalidate()
                if (attached) {
                    postDelayed(this, FRAME_TIME)
                }
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        canvas.rotate(currentDegree, width / 2f, height / 2f)
        super.onDraw(canvas)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        attached = true
        post(runnable)
    }

    override fun onDetachedFromWindow() {
        attached = false
        super.onDetachedFromWindow()
    }
}
