package food.presentation.splash


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import designSystem.FoodBackGroundColor
import designSystem.FoodSplashTopBackground
import designSystem.FoodTextSecondaryColor
import food.presentation.utils.FoodButton
import food.presentation.utils.FoodDescriptionText
import food.presentation.utils.FoodTitelText
import food.presentation.utils.OneTimeClickableText
import food.presentation.utils.SplashIcon
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.dismiss
import fooddelivery.composeapp.generated.resources.ic_gradient
import fooddelivery.composeapp.generated.resources.ic_logo_splash
import fooddelivery.composeapp.generated.resources.order_now
import fooddelivery.composeapp.generated.resources.splash_des
import fooddelivery.composeapp.generated.resources.splash_ti
import fooddelivery.composeapp.generated.resources.splash_tiii
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun SplashScreenRoot(
    onOrderClick: () -> Unit = {},
    onDismissClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(FoodSplashTopBackground)
    ) {
        Box {
            Image(
                painterResource(Res.drawable.ic_logo_splash),
                modifier = Modifier.padding(vertical = 30.dp, horizontal = 3.dp),
                contentDescription = null
            )
            Image(
                painterResource(Res.drawable.ic_gradient),
                modifier = Modifier.padding(horizontal = 3.dp),
                contentDescription = null
            )
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Card(
            shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp),
            colors = CardDefaults.cardColors(FoodBackGroundColor),
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(vertical = 40.dp)
            ) {
                SplashIcon(
                    modifier = Modifier.padding(vertical = 20.dp)
                )
                FoodTitelText(
                    modifier = Modifier.padding(),
                    name = stringResource(Res.string.splash_ti)
                )
                FoodTitelText(
                    modifier = Modifier.padding(),
                    name = stringResource(Res.string.splash_tiii),
                )

                Box(modifier = Modifier.padding(horizontal = 18.dp, vertical = 22.dp)) {
                    FoodDescriptionText(
                        name = stringResource(Res.string.splash_des),
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Normal,
                        color = FoodTextSecondaryColor,

                        )
                }
                FoodButton(
                    onClick = {
                        onOrderClick()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(horizontal = 20.dp),
                    text = stringResource(Res.string.order_now)
                )

                Row(
                    modifier = Modifier.padding(horizontal = 50.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OneTimeClickableText(
                        modifier = Modifier,
                        text = stringResource(Res.string.dismiss),
                        onClick = {
                            onDismissClick()
                        }
                    )

                }
            }
        }
    }
}



