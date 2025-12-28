package org.codefirst.spinnerhud

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.TextView

class SpinnerDialog(
    context: Context,
) : Dialog(context) {
    var label: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.spinner_dialog)
        window?.apply {
            setBackgroundDrawable(ColorDrawable(0))
            addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            attributes.apply {
                dimAmount = 0.5f
                gravity = Gravity.CENTER
            }
        }

        setCanceledOnTouchOutside(false)
        initViews()
    }

    private fun initViews() {
        findViewById<FrameLayout>(R.id.container).also {
            it.removeAllViews()
            it.addView(SpinnerView(context))
        }
        findViewById<TextView>(R.id.label).apply {
            text = label
            visibility = if (label.isBlank()) View.GONE else View.VISIBLE
        }
    }
}
