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

    fun setLabel(label: String): SpinnerHUD {
        dialog.label = label
        return this
    }

    fun setCancellable(isCancellable: Boolean): SpinnerHUD {
        dialog.setCancelable(isCancellable)
        return this
    }

    fun dismiss() {
        if (isShowing) {
            dialog.dismiss()
        }
    }
}
