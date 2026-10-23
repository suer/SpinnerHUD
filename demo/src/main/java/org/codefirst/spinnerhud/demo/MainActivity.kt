package org.codefirst.spinnerhud.demo

import android.os.Bundle
import android.os.Handler
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import org.codefirst.spinnerhud.SpinnerHUD
import org.codefirst.spinnerhud.demo.ui.theme.SpinnerHUDTheme
import org.codefirst.spinnerhud.compose.SpinnerHUD as ComposeSpinnerHUD
import kotlin.time.DurationUnit
import kotlin.time.toDuration

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpinnerHUDTheme {
                var showComposeHud by remember { mutableStateOf(false) }

                MainScreen(
                    onShowViewHudClick = ::showViewHud,
                    onShowComposeHudClick = { showComposeHud = true },
                )

                if (showComposeHud) {
                    LaunchedEffect(Unit) {
                        delay(HUD_DURATION_MILLIS.toDuration(DurationUnit.MILLISECONDS))
                        showComposeHud = false
                    }
                    ComposeSpinnerHUD(
                        onDismissRequest = { showComposeHud = false },
                        label = "Loading.....",
                        cancellable = true,
                    )
                }
            }
        }
    }

    private fun showViewHud() {
        val hud = SpinnerHUD.create(this).setLabel("Loading.....").setCancellable(true).show()
        Handler(mainLooper).postDelayed(
            {
                hud.dismiss()
            },
            HUD_DURATION_MILLIS,
        )
    }

    private companion object {
        const val HUD_DURATION_MILLIS = 4000L
    }
}
