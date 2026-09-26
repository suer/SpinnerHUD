package org.codefirst.spinnerhud.demo.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import org.codefirst.spinnerhud.demo.R

@Composable
fun SpinnerHUDTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme =
        if (darkTheme) {
            darkColorScheme(
                primary = colorResource(R.color.purple_200),
                onPrimary = colorResource(R.color.black),
            )
        } else {
            lightColorScheme(
                primary = colorResource(R.color.purple_500),
                onPrimary = colorResource(R.color.white),
            )
        }
    MaterialTheme(colorScheme = colorScheme, content = content)
}
