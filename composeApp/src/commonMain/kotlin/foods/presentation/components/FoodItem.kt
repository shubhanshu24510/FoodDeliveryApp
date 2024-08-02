package foods.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import designSystem.FoodTextPrimaryColor
import designSystem.FoodTextSecondaryColor
import designSystem.FoodWhiteColor
import designSystem.RobotoFontFamily
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.order_now
import org.jetbrains.compose.resources.stringResource

@Composable
fun FoodTitalText(
    modifier: Modifier = Modifier,
    padding: PaddingValues,
    name: String = ""
) {
    Text(
        text = name,
        fontSize = 34.sp,
        color = FoodTextPrimaryColor,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontFamily = RobotoFontFamily(),
        lineHeight = 0.41.sp,
        softWrap = true,
        modifier = Modifier.padding(padding),
        textAlign = TextAlign.Center
    )
}

@Composable
fun FoodDescriptionText(
    modifier: Modifier = Modifier,
    name: String = ""
) {
    Box(modifier = Modifier) {
        Text(
            text = name,
            fontSize = 17.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal,
            softWrap = true,
            color = FoodTextSecondaryColor,
            fontFamily = RobotoFontFamily(),
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
        color = FoodTextSecondaryColor,
        fontWeight = FontWeight.SemiBold,
        softWrap = true,
        fontFamily = RobotoFontFamily(),
        textAlign = TextAlign.Center,
    )
}