package org.codefirst.spinnerhud.demo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import org.codefirst.spinnerhud.demo.ui.theme.SpinnerHUDTheme

@Composable
fun MainScreen(
    onShowHudClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize().padding(top = 200.dp),
        contentAlignment = Alignment.Center,
    ) {
        // Mimic the MaterialComponents (M2) button style used by the XML theme
        Button(
            onClick = onShowHudClick,
            modifier = Modifier.heightIn(min = 36.dp),
            shape = RoundedCornerShape(4.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp),
        ) {
            Text(
                text = "Button".uppercase(),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = 0.0892.em,
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 411, heightDp = 781)
@Composable
private fun MainScreenPreview() {
    SpinnerHUDTheme {
        MainScreen(onShowHudClick = {})
    }
}
