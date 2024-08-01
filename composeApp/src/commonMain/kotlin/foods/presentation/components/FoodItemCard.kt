package foods.presentation.components

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import designSystem.FoodBackGroundColor
import designSystem.FoodBorderColor
import designSystem.FoodPrimaryButtonColor
import designSystem.FoodTextPrimaryColor
import designSystem.FoodTextSecondaryColor
import designSystem.FoodWhiteColor
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.boston_lettuce
import fooddelivery.composeapp.generated.resources.ic_heart
import fooddelivery.composeapp.generated.resources.ic_shopping_cart
import fooddelivery.composeapp.generated.resources.itemPrice
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview



@Preview
@Composable
fun FoodItemCard(modifier: Modifier = Modifier) {
    Box {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp)
                .height(160.dp),
//            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
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
                    painter = painterResource(Res.drawable.boston_lettuce),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 177.dp, height = 128.dp)
                        .padding(8.dp)
                )
                Column(
                    modifier = Modifier
                        .size(width = 177.dp, height = 128.dp)
                        .padding(horizontal = 5.dp)
                    .weight(1f)
                ) {
                    Text(
                        text = stringResource(Res.string.boston_lettuce),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.Default,
                        style = TextStyle.Default,
                        color = FoodTextPrimaryColor,
                        modifier = Modifier.padding(7.dp)
                    )
                    Text(
                        text = stringResource(Res.string.itemPrice,),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily.Default,
                        color = FoodTextSecondaryColor,
                        modifier = Modifier.padding(horizontal = 8.dp)

                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        FoodButtonCard(
                            icon = vectorResource(Res.drawable.ic_heart),
                            onClick = {},
                        )
                        FoodButtonCard(
                            icon = vectorResource(Res.drawable.ic_shopping_cart),
                            onClick = {},
                            color = FoodPrimaryButtonColor,
                            tintColor = FoodWhiteColor
                        )
                    }
                }
            }
        }
    }

}

//@Preview
//@Composable
//fun FoodItemCard(modifier: Modifier = Modifier) {
//    Box(
//        modifier = Modifier.fillMaxWidth()
//            .height(160.dp).padding(horizontal = 10.dp)
//    ) {
//        Row(
//            modifier = Modifier
//                .size(width = 177.dp, height = 128.dp)
//                .padding(3.dp)
//        ) {
//            Image(
//                painter = painterResource(Res.drawable.boston_lettuce),
//                modifier = Modifier.fillMaxSize(),
//                contentDescription = null,
//            )
//                Column(modifier = Modifier.fillMaxSize()) {
//                    Text(
//                        text = stringResource(Res.string.boston_lettuce),
//                        textAlign = TextAlign.Center,
//                        modifier = Modifier.padding(10.dp)
//                    )
//                    Text("$1.10 € / piece")
//                    Row(
//                        modifier = Modifier.fillMaxWidth()
//                            .padding(top = 25.dp),
//                        horizontalArrangement = Arrangement.SpaceBetween,
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        FoodButtonCard(
//                            icon = vectorResource(Res.drawable.ic_heart),
//                            onClick = {},
//                        )
//                        FoodButtonCard(
//                            icon = vectorResource(Res.drawable.ic_shopping_cart),
//                            onClick = {},
//                            color = FoodPrimaryButtonColor,
//                            tintColor = FoodWhiteColor
//                        )
//                    }
//                }
//            }
//            }
//
//    }
//}

@Composable
fun FoodButtonCard(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    onClick: () -> Unit = {},
    color: Color = Color.White,
    tintColor: Color = FoodTextSecondaryColor
) {
    Card(
        modifier = Modifier
            .size(width = 78.dp, height = 40.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(color),
        border = BorderStroke(width = 0.3.dp, color = FoodBorderColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
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
