@file:OptIn(ExperimentalMaterial3Api::class)

package payment.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import designSystem.FoodBackGroundColor
import designSystem.FoodBorderColor
import designSystem.FoodTextPrimaryColor
import designSystem.FoodTextSecondaryColor
import designSystem.FoodWhiteColor
import designSystem.RobotoFontFamily
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.card_number
import fooddelivery.composeapp.generated.resources.credit_debit
import fooddelivery.composeapp.generated.resources.cvc
import fooddelivery.composeapp.generated.resources.expiry_date
import fooddelivery.composeapp.generated.resources.ic_back_arrow
import fooddelivery.composeapp.generated.resources.ic_hint__1_
import fooddelivery.composeapp.generated.resources.ic_mc_symbol
import fooddelivery.composeapp.generated.resources.ic_mc_symbol_1
import fooddelivery.composeapp.generated.resources.ic_take_a_photo_icon
import fooddelivery.composeapp.generated.resources.name_on_card
import fooddelivery.composeapp.generated.resources.use_this_card
import foods.presentation.components.FoodButton
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import payment.ui.components.BankCardUi

@Composable
fun CardDetailsScreen(modifier: Modifier = Modifier) {
    Scaffold(
        containerColor = FoodBackGroundColor,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(FoodBackGroundColor),
                title = {},
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
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 5.dp)
                .fillMaxSize(),
        ) {
            Row(
                modifier = Modifier.padding(start = 18.dp)
            ) {
                Text(
                    stringResource(Res.string.credit_debit),
                    style = TextStyle.Default.copy(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = FoodTextPrimaryColor,
                        fontFamily = RobotoFontFamily(),
                        textAlign = TextAlign.Center
                    )
                )
            }
            BankCardUi(
                modifier = Modifier.padding(13.dp),
                baseColor = Color(0xFFFF9800),
                cardNumber = "4747 4747 4747 4747",
                cardHolder = "ALEXNDRA SMITH",
                expires = "07/21",
                brand = "WISA"
            )
//            Spacer(modifier = Modifier.height(16.dp))

            ///Camera Scanner
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 160.dp, vertical = 3.dp)
                    .background(FoodBackGroundColor)
                    .padding(16.dp)
            ) {
                Icon(
                    vectorResource(Res.drawable.ic_take_a_photo_icon),
                    tint = FoodTextSecondaryColor,
                    modifier = Modifier.
                    background(FoodBackGroundColor)
                        .clickable {

                    },
                    contentDescription = null
                )
            }

            // Name on card input field
            CardOutlinedTextField(
                title = stringResource(Res.string.name_on_card),
                value = "",
                onValueChange = { /* Handle name change */ },
                keyboardType = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier.fillMaxWidth()
                    .height(49.dp)
                    .padding(horizontal = 13.dp)
            )

            Spacer(modifier = Modifier.height(22.dp))

            // Card number input field
            CardOutlinedTextField(
                title = stringResource(Res.string.card_number),
                value = "",
                onValueChange = { /* Handle name change */ },
                trailingIcon = {
                    Image(
                        vectorResource(Res.drawable.ic_mc_symbol_1), contentDescription = null,
                        modifier = Modifier.size(width = 32.35.dp, height = 20.dp)
                    )
                },
                keyboardType = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
                    .height(49.dp)
                    .padding(horizontal = 13.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Expiry date input field
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 13.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier.height(69.dp)
                ) {
                    Text(
                        text = stringResource(Res.string.expiry_date),
                        modifier = Modifier.padding(horizontal = 12.dp),
                        style = TextStyle.Default.copy(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = RobotoFontFamily(),
                            textAlign = TextAlign.Center,
                            color = FoodTextSecondaryColor,
                        )
                    )
                    Spacer(modifier = Modifier.height(2.dp))

                    OutlinedTextField(
                        value = "",
                        onValueChange = { /* Handle expiry date change */ },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.weight(1f)
                            .width(176.dp)
                            .height(49.dp),
                        colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = FoodBorderColor),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
                Spacer(modifier = Modifier.width(25.dp))
                Column(
                    modifier = Modifier.height(69.dp)
                ) {
                    Text(
                        text = stringResource(Res.string.cvc),
                        modifier = Modifier.padding(horizontal = 12.dp),
                        style = TextStyle.Default.copy(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = RobotoFontFamily(),
                            textAlign = TextAlign.Center,
                            color = FoodTextSecondaryColor,
                        )
                    )
                    Spacer(modifier = Modifier.height(2.dp))

                    OutlinedTextField(
                        value = "",
                        onValueChange = { /* Handle CVC change */ },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.weight(1f)
                            .width(176.dp)
                            .height(49.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor =
                            FoodBorderColor
                        ),
                        trailingIcon = {
                            Icon(
                                imageVector = vectorResource(Res.drawable.ic_hint__1_),
                                modifier = Modifier.size(width = 36.dp, height = 26.dp)
                                    .padding(end = 7.dp),
                                contentDescription = null
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
            }
            Spacer(modifier = Modifier.height(45.dp))
            // Use this card button
            FoodButton(
                onClick = {},
                text = stringResource(Res.string.use_this_card)
            )
        }
    }
}

@Composable
fun CardOutlinedTextField(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    keyboardType: KeyboardOptions,
    onValueChange: (String) -> Unit,
    trailingIcon: @Composable (() -> Unit)? = null

) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Text(
                text = title,
                modifier = Modifier.padding(start = 25.dp),
                style = TextStyle.Default.copy(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = RobotoFontFamily(),
                    textAlign = TextAlign.Center,
                    color = FoodTextSecondaryColor,
                )
            )
            Spacer(modifier = Modifier.height(2.dp))
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = FoodBorderColor),
                trailingIcon = trailingIcon,
                keyboardOptions = keyboardType,
                modifier = modifier,
            )
        }
    }
}