@file:OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)

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
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
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
import foods.presentation.components.HorizontalPagerContent
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import kotlin.math.absoluteValue

@Composable
fun FoodDetailsScreen(
    onSaveClick: () -> Unit = {},
    onPickCartClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier
    ) {
        HorizontalPagerContent()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(FoodBackGroundColor),
            contentAlignment = Alignment.BottomCenter,
        ) {
            FoodDetailsCard(
                onCardClick = onPickCartClick
            )
        }
    }
}

@Composable
fun FoodDetailsCard(
    onCardClick: () -> Unit = {},
) {
    rememberModalBottomSheetState()
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(topStart = 33.dp, topEnd = 33.dp),
        colors = CardDefaults.cardColors(containerColor = FoodBackGroundColor)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 30.dp)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier.padding(vertical = 20.dp,
                    horizontal = 3.dp)
            ) {
                FoodDetailsText(
                    name = stringResource(Res.string.boston_lettuce),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = FoodTextPrimaryColor
                )
            }
            Column(modifier = Modifier.padding(horizontal = 3.dp)) {
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
            Spacer(Modifier.height(45.dp))
            Box(modifier = Modifier.padding(horizontal = 3.dp)) {
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
//                    .padding(bottom = 40.dp)
                    .width(373.dp)
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
                            letterSpacing = 0.9.sp,
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
            Spacer(modifier = Modifier.height(30.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 30.dp)
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
                    onClick = {
                        onCardClick()
                    },
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

@OptIn(ExperimentalFoundationApi::class)
fun PagerState.calculateCurrentOffsetForPage(page: Int): Float {
    return (currentPage - page) + currentPageOffsetFraction
}