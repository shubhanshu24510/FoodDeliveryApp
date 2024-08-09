package food.presentation.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import designSystem.FoodTextPrimaryColor
import designSystem.FoodTextSecondaryColor

@Composable
fun FoodTitelText(
    modifier: Modifier = Modifier,
    name: String = ""
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(
            text = name,
            fontSize = 34.sp,
            color = FoodTextPrimaryColor,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 0.41.sp,
            softWrap = true,
            modifier = modifier,
            textAlign = TextAlign.Center
        )

    }

}


@Composable
fun OneTimeClickableText(
    modifier: Modifier,
    text: String, onClick: () -> Unit) {
    var enabled by rememberSaveable { mutableStateOf(true) }
    Text(
        modifier = modifier
            .padding(vertical = 12.dp)
            .clickable(enabled = enabled) {
                enabled = false
                onClick()
            },
        text = text,
        fontSize = 15.sp,
        fontStyle = FontStyle.Normal,
        color = FoodTextSecondaryColor,
        fontWeight = FontWeight.SemiBold,
        softWrap = true,
        fontFamily = FontFamily.SansSerif,
        textAlign = TextAlign.Center,
    )
}