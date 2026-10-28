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
    fun clickingViewHudButtonInvokesCallback() {
        var viewCount = 0
        var composeCount = 0
        composeTestRule.setContent {
            SpinnerHUDTheme {
                MainScreen(
                    onShowViewHudClick = { viewCount++ },
                    onShowComposeHudClick = { composeCount++ },
                )
            }
        }

        composeTestRule.onNodeWithText("VIEW HUD").assertIsDisplayed().performClick()

        assertEquals(1, viewCount)
        assertEquals(0, composeCount)
    }

    @Test
    fun clickingComposeHudButtonInvokesCallback() {
        var viewCount = 0
        var composeCount = 0
        composeTestRule.setContent {
            SpinnerHUDTheme {
                MainScreen(
                    onShowViewHudClick = { viewCount++ },
                    onShowComposeHudClick = { composeCount++ },
                )
            }
        }

        composeTestRule.onNodeWithText("COMPOSE HUD").assertIsDisplayed().performClick()

        assertEquals(0, viewCount)
        assertEquals(1, composeCount)
    }
}
