package food.presentation.splash


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import designSystem.FoodBackGroundColor
import designSystem.FoodSplashTopBackground
import designSystem.FoodTextSecondaryColor
import designSystem.RobotoFontFamily
import food.presentation.utils.FoodButton
import food.presentation.utils.FoodDescriptionText
import food.presentation.utils.FoodTitalText
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
                SplashIcon(modifier = Modifier)

                Column(modifier = Modifier.padding(vertical = 20.dp)) {
                    FoodTitalText(
                        name = stringResource(Res.string.splash_ti),
                        padding = PaddingValues(),
                        modifier = Modifier.padding(horizontal = 75.dp, vertical = 2.dp),
                    )
                    Row(modifier = Modifier.padding(horizontal = 26.dp)) {
                        FoodTitalText(
                            name = stringResource(Res.string.splash_tiii),
                            padding = PaddingValues()
                        )
                    }

                }
                Box(modifier = Modifier.padding(horizontal = 18.dp, vertical = 13.dp)) {
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
                    text = stringResource(Res.string.order_now)
                )

                Row(
                    modifier = Modifier.padding(horizontal = 50.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OneTimeClickableText(
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



