@file:OptIn(ExperimentalFoundationApi::class)

package foods.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import designSystem.FoodBackGroundColor
import designSystem.FoodPrimaryButtonColor
import designSystem.FoodTextPrimaryColor
import designSystem.FoodTextSecondaryColor
import designSystem.FoodWhiteColor
import designSystem.RobotoFontFamily
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.add_to_cart
import fooddelivery.composeapp.generated.resources.boston_lettuce
import fooddelivery.composeapp.generated.resources.descriptionNote
import fooddelivery.composeapp.generated.resources.ic_heart
import fooddelivery.composeapp.generated.resources.ic_shopping_cart
import fooddelivery.composeapp.generated.resources.ic_vegetable
import fooddelivery.composeapp.generated.resources.itemPrice
import fooddelivery.composeapp.generated.resources.spain
import fooddelivery.composeapp.generated.resources.spain_des
import foods.presentation.components.FoodButton
import foods.presentation.components.FoodButtonCard
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun FoodDetailsScreen(modifier: Modifier = Modifier) {
    val state = rememberPagerState(pageCount = { 5 })
//    HorizontalPager(
//        state = state,
//        pageContent = {
//            Image(vectorResource(Res.drawable.ic_vegetable),
//                contentDescription = null)
//        }
//
//    )
    Box(
        modifier = Modifier.fillMaxSize()
            .background(FoodBackGroundColor),
        contentAlignment = Alignment.BottomCenter,
    ) {
        FoodDetailsCard()

    }
}


@Composable
fun FoodDetailsCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(topStart = 33.dp, topEnd = 33.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .size(width = 414.dp, height = 600.dp)
        ) {
            Box(modifier =Modifier.padding(vertical = 20.dp, horizontal = 3.dp)
                .padding(top = 50.dp)) {
                FoodDetailsText(
                    name = stringResource(Res.string.boston_lettuce),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = FoodTextPrimaryColor
                )
            }
            Column(modifier =Modifier.padding(horizontal = 3.dp)) {
                FoodDetailsText(
                    name = stringResource(Res.string.itemPrice),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(horizontal = 20.dp),
                    color = FoodTextSecondaryColor
                )
                Spacer(modifier = Modifier.height(10.dp))
                FoodDetailsText(
                    name = stringResource(Res.string.descriptionNote),
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Medium,
                    color = FoodPrimaryButtonColor
                )
            }
            Spacer(Modifier.height(40.dp))
            Box(modifier =Modifier.padding(horizontal = 3.dp)) {
                FoodDetailsText(
                    name = stringResource(Res.string.spain),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = FoodTextPrimaryColor
                )
            }
            Box(
                modifier = Modifier
                    .padding(vertical = 20.dp, horizontal = 3.dp)
                    .size(width = 373.dp, height = 194.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = stringResource(Res.string.spain_des),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = FoodTextSecondaryColor,
                            fontSize = 17.sp,
                            letterSpacing = 0.9.sp
                            ,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Normal,
                            ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(
                                align = Alignment.CenterVertically
                            ),
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                FoodButtonCard(
                    icon = vectorResource(Res.drawable.ic_heart),
                    onClick = {},
                    color = FoodWhiteColor,
                    width = 85.dp,
                    height = 50.dp,
                )
                Spacer(modifier = Modifier.width(18.dp))

                FoodButton(
                    onClick = {},
                    modifier = Modifier.padding(horizontal = 8.dp),
                    icon = vectorResource(Res.drawable.ic_shopping_cart),
                    text = stringResource(Res.string.add_to_cart)
                )
            }
        }
    }
}

@Composable
fun FoodDetailsText(
    modifier: Modifier = Modifier,
    name: String,
    fontWeight: FontWeight,
    color: Color,
    fontSize: TextUnit
) {
    Box(modifier = Modifier) {
        Text(
            text = name,
            fontSize = fontSize,
            fontStyle = FontStyle.Normal,
            fontWeight = fontWeight,
            softWrap = true,
            color = color,
            fontFamily = RobotoFontFamily(),
            textAlign = TextAlign.Center,
        )
    }
}