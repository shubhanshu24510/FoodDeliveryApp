package food.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import designSystem.FoodBackGroundColor
import designSystem.FoodPrimaryButtonColor
import designSystem.FoodTextPrimaryColor
import designSystem.FoodTextSecondaryColor
import designSystem.FoodWhiteColor
import designSystem.RobotoFontFamily
import food.data.ItemDestinationDataSources
import food.domain.ItemDestination
import food.presentation.utils.FoodButton
import food.presentation.utils.FoodButtonCard
import food.presentation.utils.FoodDescriptionText
import food.presentation.utils.FoodItemCard
import food.presentation.utils.HorizontalPagerContent
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.add_to_cart
import fooddelivery.composeapp.generated.resources.boston_lettuce
import fooddelivery.composeapp.generated.resources.descriptionNote
import fooddelivery.composeapp.generated.resources.ic_heart
import fooddelivery.composeapp.generated.resources.ic_shopping_cart
import fooddelivery.composeapp.generated.resources.itemPrice
import fooddelivery.composeapp.generated.resources.order_now
import fooddelivery.composeapp.generated.resources.spain
import fooddelivery.composeapp.generated.resources.spain_des
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun FoodDetailsScreen(
    onSaveClick: () -> Unit = {},
    onPickCartClick: () -> Unit = {},
) {
    Scaffold(
        bottomBar = {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.padding(horizontal = 15.dp)
                    .padding(bottom = 25.dp)
            ) {
                FoodButtonCard(
                    icon = vectorResource(Res.drawable.ic_heart),
                    onClick = {},
                    color = FoodWhiteColor,
                    width = 78.dp,
                    height = 56.dp,
                )
                Spacer(modifier = Modifier.width(20.dp))
                FoodButton(
                    onClick = {
                        onPickCartClick()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    text = stringResource(Res.string.add_to_cart),
                    icon = vectorResource(Res.drawable.ic_shopping_cart)
                )
            }
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                HorizontalPagerContent()

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(FoodBackGroundColor),
                    contentAlignment = Alignment.BottomCenter,
                ) {
                    FoodDetailsCard(
                        onCardClick = onPickCartClick,
                    )
                }
            }
        }
    )
}

@Composable
fun FoodDetailsCard(
    onCardClick: () -> Unit = {},
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(topStart = 21.dp, topEnd = 33.dp),
        colors = CardDefaults.cardColors(containerColor = FoodBackGroundColor)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(35.dp))
            FoodDescriptionText(
                name = stringResource(Res.string.boston_lettuce),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = FoodTextPrimaryColor,
                modifier = Modifier.padding(horizontal = 3.dp)
            )
            Row(
                modifier = Modifier.padding(vertical = 12.dp)
            ) {
                Text(
                    text = "1.10",
                    style = TextStyle.Default.copy(
                        fontSize = 32.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        color = FoodTextPrimaryColor
                    )
                )
                Text(
                    text = stringResource(Res.string.itemPrice),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.SansSerif,
                    color = FoodTextSecondaryColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                )
            }

            FoodDescriptionText(
                name = stringResource(Res.string.descriptionNote),
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = FoodPrimaryButtonColor
            )
            Spacer(modifier = Modifier.height(35.dp))

            FoodDescriptionText(
                name = stringResource(Res.string.spain),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = FoodTextPrimaryColor,
                modifier = Modifier.padding(horizontal = 15.dp)
            )
            LazyColumn(
                modifier = Modifier.padding(bottom = 128.dp)
                    .padding(horizontal = 5.dp, vertical = 5.dp)
                    .fillMaxHeight(),
                flingBehavior = ScrollableDefaults.flingBehavior(),
                reverseLayout = false,
            ) {
                item {
                    Text(
                        text = stringResource(Res.string.spain_des),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = FoodTextSecondaryColor,
                            fontSize = 17.sp,
                            lineHeight = TextUnit(26f, TextUnitType.Sp),
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

        }

    }
}


