@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package foods.presentation


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import designSystem.FoodBackGroundColor
import designSystem.FoodSelectedBackgroundViolet
import designSystem.FoodSelectedVioletColor
import designSystem.FoodTextPrimaryColor
import designSystem.FoodTextSecondaryColor
import designSystem.FoodWhiteColor
import designSystem.RobotoFontFamily
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.change
import fooddelivery.composeapp.generated.resources.checkout
import fooddelivery.composeapp.generated.resources.delivery_address
import fooddelivery.composeapp.generated.resources.ic_back_arrow
import fooddelivery.composeapp.generated.resources.ic_bikee
import fooddelivery.composeapp.generated.resources.ic_checj
import fooddelivery.composeapp.generated.resources.ic_credit_card_icon
import fooddelivery.composeapp.generated.resources.ic_dronee
import fooddelivery.composeapp.generated.resources.ic_home_grid
import fooddelivery.composeapp.generated.resources.ic_home_icon
import fooddelivery.composeapp.generated.resources.ic_shopping_cart
import fooddelivery.composeapp.generated.resources.ic_user
import fooddelivery.composeapp.generated.resources.ic_walking_iocn
import fooddelivery.composeapp.generated.resources.non_contact_delivery
import fooddelivery.composeapp.generated.resources.payment_method
import fooddelivery.composeapp.generated.resources.pick_by_drone
import fooddelivery.composeapp.generated.resources.pick_courier
import fooddelivery.composeapp.generated.resources.pick_myself
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun CheckoutScreen() {
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
                        onClick = { /* handle back action */ },
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
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(horizontal = 40.dp)
                    ) {
                        Icon(
                            imageVector = vectorResource(Res.drawable.ic_home_grid),
                            contentDescription = "Home"
                        )
                    }
                    IconButton(
                        onClick = { /*TODO*/ },
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
                onChangeClick = { /* handle change payment method */ }
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

@Composable
fun CardSection(
    title: String,
    initialValue: String = "",
    icon: ImageVector?,
    onChangeClick: () -> Unit = {},
    content: @Composable (() -> Unit)? = null
) {
    var isEditable by remember { mutableStateOf(false) }
    var textFieldValue by remember { mutableStateOf(initialValue) }

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            title,
                            style = TextStyle.Default.copy(
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = RobotoFontFamily(),
                                textAlign = TextAlign.Center,
                                color = FoodTextPrimaryColor
                            )
                        )

                        Text(
                            text = stringResource(Res.string.change),
                            style = TextStyle.Default.copy(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = RobotoFontFamily(),
                                textAlign = TextAlign.Center,
                                color = FoodSelectedVioletColor
                            ),
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.clickable {
                                isEditable = !isEditable
                                onChangeClick()
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (icon != null) {
                            Icon(
                                icon,
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                                    .align(Alignment.Top)
                            )
                        }
                        Spacer(modifier = Modifier.width(25.dp))
                        Box {
                            if (isEditable) {
                                TextField(
                                    value = textFieldValue,
                                    onValueChange = { newValue ->
                                        if (newValue.length <= 16 && newValue.all { it.isDigit() }) {
                                            textFieldValue = newValue
                                        }
                                    },
                                    textStyle = TextStyle.Default.copy(
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight.Normal,
                                        fontFamily = RobotoFontFamily(),
                                        textAlign = TextAlign.Center,
                                        color = FoodTextSecondaryColor
                                    ),
                                    modifier = Modifier.fillMaxWidth()
                                )
                            } else {
                                Text(
                                    textFieldValue,
                                    color = Color.Gray,
                                    overflow = TextOverflow.Visible,
                                    style = TextStyle.Default.copy(
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight.Normal,
                                        fontFamily = RobotoFontFamily(),
                                        textAlign = TextAlign.Center,
                                        color = FoodTextSecondaryColor
                                    ),
                                )
                            }
                        }
                    }
                }
            }
        }
    }
    content?.invoke()
}

@Composable
fun DeliveryOption(
    option: String,
    icon: Painter,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .background(if (selected) FoodSelectedBackgroundViolet else FoodBackGroundColor)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = if (selected) FoodSelectedVioletColor else FoodTextSecondaryColor
        )

        Spacer(modifier = Modifier.width(25.dp))

        Text(
            text = option,
            style = TextStyle.Default.copy(
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                fontFamily = RobotoFontFamily(),
                fontWeight = FontWeight.Normal,
                color = if (selected) FoodSelectedVioletColor else FoodTextSecondaryColor
            )
        )

        if (selected) {
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(Res.drawable.ic_checj),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = FoodSelectedVioletColor
            )
        }
    }
}

@Composable
fun NonContactDeliverySwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(start = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(Res.string.non_contact_delivery),
            style = TextStyle.Default.copy(
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                fontFamily = RobotoFontFamily(),
                fontWeight = FontWeight.Bold,
                color = FoodTextPrimaryColor,
            )
        )
        var checked by remember { mutableStateOf(true) }

        Switch(
            modifier = Modifier
                .size(width = 74.dp, height = 30.dp)
                .border(BorderStroke(width = 0.dp, color = Color.White))
                .semantics { contentDescription = "Demo with icon" },
            checked = checked,
            onCheckedChange = { checked = it },
            colors = SwitchDefaults.colors(FoodWhiteColor),
//            thumbContent = {
//                if (checked) {
//                    Icon(
//                        imageVector = Icons.Filled.Check,
//                        contentDescription = null,
//                        modifier = Modifier.size(SwitchDefaults.IconSize),
//                    )
//                }
//            }
        )
    }
}

@Composable
fun CheckoutTitleOption(
    title: String,
    icon: ImageVector?,
    onChangeClick: () -> Unit,
    content: @Composable() (() -> Unit)? = null
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .padding(start = 10.dp)
    ) {
        Text(
            title,
            style = TextStyle.Default.copy(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = RobotoFontFamily(),
                textAlign = TextAlign.Center,
                color = FoodTextPrimaryColor
            )
        )
        Text(
            text = stringResource(Res.string.change),
            style = TextStyle.Default.copy(
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = RobotoFontFamily(),
                textAlign = TextAlign.Center,
                color = FoodSelectedVioletColor
            ),
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.clickable(onClick = onChangeClick)
        )
    }
}
