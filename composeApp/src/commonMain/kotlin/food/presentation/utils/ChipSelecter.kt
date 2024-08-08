package food.presentation.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import designSystem.FoodTextSecondaryColor
import designSystem.FoodWhiteColor
import designSystem.RobotoFontFamily
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.ic_checj
import org.jetbrains.compose.resources.painterResource

@Composable
fun ChipSelector(
    isSelected: Boolean,
    text: String,
    onChecked: (Boolean) -> Unit,
) {
    Box(
        modifier = Modifier
            .padding(
                vertical = 10.dp,
                horizontal = 15.dp
            )
            .border(
                width = 1.dp,
                color = FoodWhiteColor,
                shape = RoundedCornerShape(30.dp)
            )
            .background(
                color = FoodWhiteColor,
                shape = RoundedCornerShape(30.dp)
            )
            .clip(RoundedCornerShape(30.dp))
            .clickable {
                onChecked(!isSelected)
            }
            .padding(horizontal = 15.dp, vertical = 10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            if (isSelected) {
                Icon(
                    painter = painterResource(Res.drawable.ic_checj),
                    tint = Color(0xFF6C0EE4),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = RobotoFontFamily(),
                ),
                color = if (isSelected) Color(0xFF6C0EE4) else FoodTextSecondaryColor
            )
        }

    }
}