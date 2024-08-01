package foods.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import designSystem.FoodBorderColor
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.ic_search
import fooddelivery.composeapp.generated.resources.search
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun FoodOutlinedSearchTextField(
    modifier: Modifier = Modifier,
//    onSearchClick: () -> Unit
) {
    val (value, onValueChange) = remember { mutableStateOf("") }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(fontSize = 17.sp),
        shape = RoundedCornerShape(30.dp),
        colors =OutlinedTextFieldDefaults.colors(unfocusedBorderColor = FoodBorderColor),
        leadingIcon = {
            Icon(imageVector = vectorResource(Res.drawable.ic_search),
                 contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .clickable {
//                    onSearchClick()
                }
            )
        },
//        border = BorderStroke(width = 1.dp, color = Color.Transparent),
//        elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 18.dp)
            .background(Color.White, RoundedCornerShape(16.dp)),
        placeholder = {
            Box(modifier =Modifier
                .height(49.dp)){
                Text(text = stringResource(Res.string.search),
                    fontSize = 15.sp,
                    letterSpacing = TextUnit.Unspecified,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Normal,
                    lineHeight =24.sp ,
                    color = Color(0xFF9586A8))
            }
           },
    )
}