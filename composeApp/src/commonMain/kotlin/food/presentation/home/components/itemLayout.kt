package food.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import designSystem.FoodTextPrimaryColor
import designSystem.FoodTextSecondaryColor
import designSystem.RobotoFontFamily
import food.domain.Destination
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.quantity
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun ItemLayout(
    destination: Destination,
    onCardClick: () -> Unit = {}
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxWidth()
    ) {
        Card(
            modifier = Modifier.size(width = 177.dp, height = 211.dp)
                .clickable {
                    onCardClick()
                },
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Image(
                painter = painterResource(resource = destination.imageRes),
//                painter = painterResource(Res.drawable.ic_vegetable),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
                    .size(width = 177.dp, height = 140.dp),
                contentScale = ContentScale.Fit
            )
            FoodItemCardText(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                name = destination.title,
                style = TextStyle.Default.copy(
                    fontSize = 18.sp,
                ),
                color = FoodTextPrimaryColor,
                fontWeight = FontWeight.Bold
            )
            FoodItemCardText(
                name = stringResource(Res.string.quantity),
                style = TextStyle.Default.copy(
                    fontSize = 12.sp
                ),
                color = FoodTextSecondaryColor,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(horizontal = 18.dp)
            )
        }

    }
}

@Composable
fun FoodItemCardText(
    modifier: Modifier,
    name: String,
    style: TextStyle,
    color: Color,
    fontWeight: FontWeight
) {
    Text(
        text = name,
        color = color,
        fontWeight = fontWeight,
        textAlign = TextAlign.Center,
        softWrap = true,
        style = style,
        fontFamily = RobotoFontFamily(),
        modifier = modifier
    )
}