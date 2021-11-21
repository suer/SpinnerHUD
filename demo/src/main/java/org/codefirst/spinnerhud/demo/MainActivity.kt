package org.codefirst.spinnerhud.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import org.codefirst.spinnerhud.R
import org.codefirst.spinnerhud.SpinnerHUD

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button_hud)?.setOnClickListener {
            val hud = SpinnerHUD.create(this).setLabel("Loading.....").show()
            Handler().postDelayed(
                {
                    hud.dismiss()
                },
                4000
            )
        }
    }
}
