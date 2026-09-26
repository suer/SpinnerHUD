package org.codefirst.spinnerhud.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.activity.compose.setContent
import org.codefirst.spinnerhud.SpinnerHUD
import org.codefirst.spinnerhud.demo.ui.theme.SpinnerHUDTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpinnerHUDTheme {
                MainScreen(onShowHudClick = ::showHud)
            }
        }
    }

    private fun showHud() {
        val hud = SpinnerHUD.create(this).setLabel("Loading.....").setCancellable(true).show()
        Handler(mainLooper).postDelayed(
            {
                hud.dismiss()
            },
            4000
        )
    }
}
