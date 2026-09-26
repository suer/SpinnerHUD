package org.codefirst.spinnerhud.demo

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.codefirst.spinnerhud.demo.ui.theme.SpinnerHUDTheme
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun clickingButtonInvokesCallback() {
        var clickCount = 0
        composeTestRule.setContent {
            SpinnerHUDTheme {
                MainScreen(onShowHudClick = { clickCount++ })
            }
        }

        composeTestRule.onNodeWithText("BUTTON").assertIsDisplayed().performClick()

        assertEquals(1, clickCount)
    }
}
