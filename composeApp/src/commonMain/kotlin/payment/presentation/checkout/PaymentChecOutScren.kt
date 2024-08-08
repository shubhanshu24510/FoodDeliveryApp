@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package payment.presentation.checkout

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import designSystem.FoodBackGroundColor
import designSystem.FoodTextPrimaryColor
import designSystem.RobotoFontFamily
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.checkout
import fooddelivery.composeapp.generated.resources.delivery_address
import fooddelivery.composeapp.generated.resources.ic_back_arrow
import fooddelivery.composeapp.generated.resources.ic_bikee
import fooddelivery.composeapp.generated.resources.ic_credit_card_icon
import fooddelivery.composeapp.generated.resources.ic_home_grid
import fooddelivery.composeapp.generated.resources.ic_home_icon
import fooddelivery.composeapp.generated.resources.ic_shopping_cart
import fooddelivery.composeapp.generated.resources.ic_user
import fooddelivery.composeapp.generated.resources.ic_walking_iocn
import fooddelivery.composeapp.generated.resources.payment_method
import fooddelivery.composeapp.generated.resources.pick_by_drone
import fooddelivery.composeapp.generated.resources.pick_courier
import fooddelivery.composeapp.generated.resources.pick_myself
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import payment.presentation.checkout.components.CardSection
import payment.presentation.checkout.components.CheckoutTitleOption
import payment.presentation.checkout.components.DeliveryOption
import payment.presentation.checkout.components.NonContactDeliverySwitch

@Composable
fun CheckoutScreen(
    onChangeClick: () -> Unit = {},
    onHomeClick: () -> Unit = {},
    onCartClick: () -> Unit = {},
) {
    val nonContactDelivery = remember { mutableStateOf(true) }
    Scaffold(
        containerColor = FoodBackGroundColor,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(Res.string.checkout),
                        modifier = Modifier.padding(start = 120.dp, top = 20.dp),
                        style = TextStyle.Default.copy(
                            fontSize = 17.sp,
                            color = FoodTextPrimaryColor,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = RobotoFontFamily(),
                            textAlign = TextAlign.Center
                        )
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                        },
                        modifier = Modifier.padding(top = 20.dp)
                    ) {
                        Icon(
                            painterResource(Res.drawable.ic_back_arrow),
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White,
                actions = {
                    IconButton(
                        onClick = { onHomeClick() },
                        modifier = Modifier.padding(horizontal = 40.dp)
                    ) {
                        Icon(
                            imageVector = vectorResource(Res.drawable.ic_home_grid),
                            contentDescription = "Home"
                        )
                    }
                    IconButton(
                        onClick = {onCartClick() },
                        modifier = Modifier.padding(horizontal = 40.dp)
                    ) {
                        Icon(
                            imageVector = vectorResource(Res.drawable.ic_shopping_cart),
                            contentDescription = "Shopping Cart"
                        )
                    }
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(horizontal = 40.dp)
                    ) {
                        Icon(
                            imageVector = vectorResource(Res.drawable.ic_user),
                            contentDescription = "Profile Screen"
                        )
                    }
                },
            )

        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CardSection(
                title = stringResource(Res.string.payment_method),
                initialValue = "**** **** **** 4747",
                icon = vectorResource(Res.drawable.ic_credit_card_icon),
                onChangeClick = { onChangeClick() }
            )
            Spacer(modifier = Modifier.height(20.dp))
            CardSection(
                title = stringResource(Res.string.delivery_address),
                initialValue = "Alexandra Smith\n" + "Cesu 31 k-2 5.st, SIA Chili\n" + "Riga\n" + "LV–1012\n" + "Latvia\n",
                icon = vectorResource(Res.drawable.ic_home_icon),
                onChangeClick = { /* handle change payment method */ }
            )
            Spacer(modifier = Modifier.height(20.dp))

            CheckoutTitleOption(
                title = "Delivery options",
                icon = null,
                onChangeClick = { /* handle change delivery options */ }
            )
            Column(
                modifier = Modifier
            ) {
                DeliveryOption(
                    option = stringResource(Res.string.pick_myself),
                    icon = painterResource(Res.drawable.ic_walking_iocn),
                    selected = false,
                    onClick = {}
                )
                Spacer(modifier = Modifier.height(10.dp))
                DeliveryOption(
                    option = stringResource(Res.string.pick_courier),
                    icon = painterResource(Res.drawable.ic_bikee),
                    selected = false,
                    onClick = {}
                )
                Spacer(modifier = Modifier.height(10.dp))
                DeliveryOption(
                    option = stringResource(Res.string.pick_by_drone),
                    icon = painterResource(Res.drawable.ic_bikee),
                    selected = false,
                    onClick = {}
                )
            }

            Spacer(modifier = Modifier.height(13.dp))
            NonContactDeliverySwitch(
                nonContactDelivery.value,
                onCheckedChange = { nonContactDelivery.value = it }
            )
        }
    }
}


