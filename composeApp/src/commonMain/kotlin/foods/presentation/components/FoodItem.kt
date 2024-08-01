package foods.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FoodTitel(
    modifier: Modifier = Modifier,
    name: String = ""
) {
    Text(
        text = name,
        fontSize = 34.sp,
        color = Color.Black.copy(alpha = 0.8f),
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily.Default,
        letterSpacing = TextUnit(0.5f, TextUnitType.Sp),
        modifier = Modifier.padding(horizontal = 75.dp, vertical = 2.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun FoodDescription(
    modifier: Modifier = Modifier,
    description: String = ""
) {
    Box(modifier = Modifier.padding(top = 1.dp)) {
        Text(
            text = description, fontSize = 16.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            softWrap = true,
            fontFamily = FontFamily.Default,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 13.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun OneTimeClickableText(text: String, onClick: () -> Unit) {
    var enabled by rememberSaveable { mutableStateOf(true) }
    Text(
        modifier = Modifier
            .padding(vertical = 12.dp)
            .clickable(enabled = enabled) {
                enabled = false
                onClick()
            },
        text = text,
        fontSize = 15.sp,
        fontStyle = FontStyle.Normal,
        color = Color(0xFf9586A8),
        fontWeight = FontWeight.SemiBold,
        softWrap = true,
        fontFamily = FontFamily.Default,
//        modifier = Modifier.padding(horizontal = 10.dp, vertical = 12.dp),
        textAlign = TextAlign.Center,
    )
}