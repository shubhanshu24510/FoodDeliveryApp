@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package food.presentation.details

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import designSystem.FoodPrimaryButtonColor
import designSystem.FoodTextPrimaryColor
import designSystem.FoodTextSecondaryColor
import designSystem.FoodWhiteColor
import food.presentation.utils.FoodButton
import food.presentation.utils.FoodButtonCard
import food.presentation.utils.FoodDescriptionText
import food.presentation.utils.HorizontalPagerContent
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.add_to_cart
import fooddelivery.composeapp.generated.resources.boston_lettuce
import fooddelivery.composeapp.generated.resources.descriptionNote
import fooddelivery.composeapp.generated.resources.ic_heart
import fooddelivery.composeapp.generated.resources.ic_shopping_cart
import fooddelivery.composeapp.generated.resources.itemPrice
import fooddelivery.composeapp.generated.resources.spain
import fooddelivery.composeapp.generated.resources.spain_des
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun FoodDetailsScreen(
    onSaveClick: () -> Unit = {},
    onPickCartClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HorizontalPagerContent()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(FoodWhiteColor),
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
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(topStart = 21.dp, topEnd = 33.dp),
        colors = CardDefaults.cardColors(containerColor = FoodWhiteColor)
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

            Spacer(modifier = Modifier.height(12.dp))

            FoodDescriptionText(
                name = stringResource(Res.string.itemPrice),
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(horizontal = 20.dp),
                color = FoodTextSecondaryColor
            )

            Spacer(modifier = Modifier.height(12.dp))

            FoodDescriptionText(
                name = stringResource(Res.string.descriptionNote),
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = FoodPrimaryButtonColor
            )

            Spacer(Modifier.height(25.dp))

                FoodDescriptionText(
                    name = stringResource(Res.string.spain),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = FoodTextPrimaryColor,
                    modifier = Modifier.padding(horizontal = 3.dp)
                )

            Box(
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 3.dp)
                    .width(373.dp)
            ) {
                Text(
                    text = stringResource(Res.string.spain_des),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = FoodTextSecondaryColor,
                        fontSize = 17.sp,
                        lineHeight = TextUnit(22f, TextUnitType.Sp),
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

            Spacer(modifier = Modifier.height(30.dp))

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
                    modifier = Modifier.padding(horizontal = 8.dp),
                    onClick = {
                        onCardClick()
                    },
                    icon = vectorResource(Res.drawable.ic_shopping_cart),
                    text = stringResource(Res.string.add_to_cart)
                )
            }
        }

    }
}


