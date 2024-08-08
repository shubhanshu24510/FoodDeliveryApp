package food.presentation.category.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import designSystem.FoodSelectedVioletColor
import designSystem.FoodTextSecondaryColor
import designSystem.FoodWhiteColor

@Composable
fun FoodFilterChip(
    itemsName: String
) {
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        onClick = { selected = !selected },
        label = {
            Text(
                text = itemsName,
                color = if (selected) FoodSelectedVioletColor else FoodTextSecondaryColor
            )
        },
        border = BorderStroke(
            width = 1.dp,
            color = FoodWhiteColor,
        ),
        colors = FilterChipDefaults.filterChipColors(if (selected) FoodSelectedVioletColor else FoodWhiteColor),
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(percent = 50),
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
    )
}
