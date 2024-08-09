package food.presentation.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import designSystem.FoodBorderColor
import designSystem.FoodTextSecondaryColor
import designSystem.FoodWhiteColor
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.ic_search
import fooddelivery.composeapp.generated.resources.search
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun FoodOutlinedSearchTextField(
    modifier: Modifier = Modifier,
    onSearchClick: () -> Unit
) {
    val (value, onValueChange) = remember { mutableStateOf("") }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(fontSize = 17.sp),
        shape = RoundedCornerShape(36.dp),
        colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = FoodBorderColor),
        leadingIcon = {
            Icon(imageVector = vectorResource(Res.drawable.ic_search),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        onSearchClick()
                    }
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .background(shape = RoundedCornerShape(36.dp), color = FoodWhiteColor)
            .height(48.dp),
        placeholder = {
            Text(
                text = stringResource(Res.string.search),
                style = TextStyle.Default.copy(
                    fontSize = 17.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = FoodTextSecondaryColor,
                    fontWeight = FontWeight.Normal
                )
            )
        },
    )
}