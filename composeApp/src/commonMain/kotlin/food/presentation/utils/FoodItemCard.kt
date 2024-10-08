package food.presentation.utils

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import designSystem.FoodBackGroundColor
import designSystem.FoodBorderColor
import designSystem.FoodPrimaryButtonColor
import designSystem.FoodTextPrimaryColor
import designSystem.FoodTextSecondaryColor
import designSystem.FoodWhiteColor
import designSystem.RobotoFontFamily
import food.domain.ItemDestination
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.ic_heart
import fooddelivery.composeapp.generated.resources.ic_shopping_cart
import fooddelivery.composeapp.generated.resources.itemPrice
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun FoodItemCard(
    destination: ItemDestination,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
    ) {
        Card(
            modifier = Modifier
                .clickable { onClick() }
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 1.dp)
                .height(160.dp),
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(FoodBackGroundColor)
        ) {
            Row(
                modifier = Modifier.fillMaxSize()
                    .size(width = 177.dp, height = 128.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(resource = destination.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 177.dp, height = 128.dp)
                        .padding(8.dp)
                )
                Column(
                    modifier = Modifier
                        .padding( horizontal = 10.dp)
                        .weight(1f)
                ) {
                    Text(
                        text = destination.title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Justify,
                        fontFamily = FontFamily.SansSerif,
                        style = TextStyle.Default,
                        color = FoodTextPrimaryColor,
                    )
                    Row(
                        modifier =Modifier.padding(vertical = 14.dp)
                    ) {
                        Text(text = destination.price,
                            style = TextStyle.Default.copy(
                                fontSize = 22.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold,
                                color = FoodTextPrimaryColor
                            ))
                        Text(
                            text = stringResource(Res.string.itemPrice),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = RobotoFontFamily(),
                            color = FoodTextSecondaryColor,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(end = 10.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.Bottom,
                    ) {
                        FoodButtonCard(
                            icon = vectorResource(Res.drawable.ic_heart),
                            onClick = {},
                            width = 78.dp,
                            height = 40.dp,
                            color = FoodWhiteColor,
                        )
                        FoodButtonCard(
                            icon = vectorResource(Res.drawable.ic_shopping_cart),
                            onClick = {},
                            color = FoodPrimaryButtonColor,
                            tintColor = FoodWhiteColor,
                            width = 78.dp,
                            height = 40.dp
                        )
                    }
                }
            }
        }
    }

}

@Composable
fun FoodButtonCard(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    width: Dp,
    height: Dp,
    onClick: () -> Unit = {},
    color: Color,
    tintColor: Color = FoodTextSecondaryColor
) {
    Card(
        modifier = Modifier
            .size(width = width, height = height)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(color),
        border = BorderStroke(width = 0.8.dp, color = FoodBorderColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = tintColor,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}
