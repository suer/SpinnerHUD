package org.codefirst.spinnerhud

import android.content.Context

class SpinnerHUD(context: Context) {
    companion object {
        fun create(context: Context) = SpinnerHUD(context)
    }

    private val dialog = SpinnerDialog(context)

    val isShowing: Boolean
        get() = dialog.isShowing

    fun show(): SpinnerHUD {
        dialog.show()
        return this
    }

    fun dismiss() {
        if (isShowing) {
            dialog.dismiss()
        }
    }
}
