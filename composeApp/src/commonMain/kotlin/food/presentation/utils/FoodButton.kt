package food.presentation.utils

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import designSystem.FoodWhiteColor
import designSystem.RobotoFontFamily
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.order_now
import org.jetbrains.compose.resources.stringResource

@Composable
fun FoodButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    icon: ImageVector? = null,
    text: String = stringResource(Res.string.order_now)
) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(size = 8.dp),
        border = BorderStroke(width = 1.dp, color = Color.Transparent),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp),
        modifier = Modifier.fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 15.dp, vertical = 4.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF0BCE83)),
        content = {
            Row(modifier = Modifier) {
                if (icon != null) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = FoodWhiteColor,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = modifier)
                Text(
                    text = text,
                    fontSize = 15.sp,
                    fontStyle = FontStyle.Normal,
                    color = FoodWhiteColor,
                    letterSpacing = 1.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    fontFamily = RobotoFontFamily(),
                    style = TextStyle.Default
                )
            }
        }
    )
}
