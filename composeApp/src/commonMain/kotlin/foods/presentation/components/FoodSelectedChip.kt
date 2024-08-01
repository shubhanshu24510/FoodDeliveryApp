package foods.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import designSystem.FoodSelectedVioletColor
import designSystem.FoodTextSecondaryColor
import designSystem.FoodWhiteColor

@Composable
fun Chip(
    text: String,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    selectedColor: Color = FoodSelectedVioletColor,
    unselectedColor: Color = FoodTextSecondaryColor,
    onChipClick: () -> Unit
) {
    val spaceSmall = 10.dp
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(50.dp))
            .border(
                width = 1.dp,
                color = FoodWhiteColor,
                shape = RoundedCornerShape(50.dp)
            )
            .clickable {
                onChipClick()
            }
            .padding(spaceSmall),
    ){
        Text(
            text = text,
            fontSize = 14.sp,
            color = if (selected) selectedColor else unselectedColor,

        )
    }
}