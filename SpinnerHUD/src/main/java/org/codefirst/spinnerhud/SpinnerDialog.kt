package org.codefirst.spinnerhud

import android.app.Dialog
import android.content.Context
import android.view.Gravity

import android.view.WindowManager

import android.graphics.drawable.ColorDrawable

import android.os.Bundle
import android.view.Window
import android.widget.FrameLayout

class SpinnerDialog(context: Context): Dialog(context) {
    private var backgroundLayout: BackgroundLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.spinner_dialog)
        window?.apply {
            setBackgroundDrawable(ColorDrawable(0))
            addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        }?.also { window ->
            val layoutParams: WindowManager.LayoutParams = window.attributes
            window.attributes = layoutParams.apply {
                dimAmount = 0.5f
                gravity = Gravity.CENTER
            }
        }

        setCanceledOnTouchOutside(false)
        initViews()
    }

    private fun initViews() {
        backgroundLayout = findViewById(R.id.background);
        findViewById<FrameLayout>(R.id.container).also {
            it.removeAllViews()
            it.addView(SpinnerView(context))
        }
    }
}
