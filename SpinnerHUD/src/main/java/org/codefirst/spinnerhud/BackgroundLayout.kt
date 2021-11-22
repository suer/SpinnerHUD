package org.codefirst.spinnerhud

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.widget.LinearLayout

class BackgroundLayout : LinearLayout {
    constructor(context: Context?) : super(context) {
        initialize()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initialize()
    }

    private fun initialize() {
        background = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            setColor(context.resources.getColor(R.color.spinnerhud_background_color, context.theme))
            cornerRadius = 10f
        }
    }
}
