package food.presentation.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import designSystem.RobotoFontFamily

@Composable
fun FoodDescriptionText(
    modifier: Modifier = Modifier,
    name: String,
    fontWeight: FontWeight,
    color: Color,
    fontSize: TextUnit
) {
    Box(modifier = Modifier) {
        Text(
            text = name,
            fontSize = fontSize,
            fontStyle = FontStyle.Normal,
            fontWeight = fontWeight,
            softWrap = true,
            color = color,
            fontFamily = RobotoFontFamily(),
            textAlign = TextAlign.Center,
        )
    }
}