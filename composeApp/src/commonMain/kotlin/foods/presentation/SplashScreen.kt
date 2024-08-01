package foods.presentation


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import foods.presentation.components.FoodButton
import foods.presentation.components.FoodDescription
import foods.presentation.components.FoodTitel
import foods.presentation.components.OneTimeClickableText
import foods.presentation.components.SplashIcon
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.dismiss
import fooddelivery.composeapp.generated.resources.ic_gradient
import fooddelivery.composeapp.generated.resources.ic_logo_splash
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
            .background(Color(0xFFA259FF))
    ) {
        Box {
            Image(
                painterResource(Res.drawable.ic_logo_splash),
                modifier = Modifier.padding(vertical = 30.dp, horizontal = 3.dp),
                contentDescription = null
            )
            Image(
                painterResource(Res.drawable.ic_gradient),
                modifier = Modifier.padding( horizontal = 3.dp),
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
            colors = CardDefaults.cardColors(Color(0xFFF6F5F5)),
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
                    FoodTitel(name = stringResource(Res.string.splash_ti))
                    Row(modifier = Modifier.padding(horizontal = 26.dp)){
                        FoodTitel(name = stringResource(Res.string.splash_tiii))
                    }

                }
                FoodDescription(description = stringResource(Res.string.splash_des))
                FoodButton(
                    onClick = {
                        onOrderClick()
                    }
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



