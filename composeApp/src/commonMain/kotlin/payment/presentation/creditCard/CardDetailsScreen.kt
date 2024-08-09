@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package payment.presentation.creditCard

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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import designSystem.FoodBackGroundColor
import designSystem.FoodTextPrimaryColor
import designSystem.FoodTextSecondaryColor
import food.presentation.utils.FoodButton
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.card_number
import fooddelivery.composeapp.generated.resources.credit_debit
import fooddelivery.composeapp.generated.resources.cvc
import fooddelivery.composeapp.generated.resources.expiry_date
import fooddelivery.composeapp.generated.resources.ic_back_arrow
import fooddelivery.composeapp.generated.resources.ic_hint
import fooddelivery.composeapp.generated.resources.ic_mc_symbol_img
import fooddelivery.composeapp.generated.resources.ic_take_a_photo_icon
import fooddelivery.composeapp.generated.resources.name_on_card
import fooddelivery.composeapp.generated.resources.use_this_card
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import payment.presentation.utils.BankCardUi
import payment.presentation.utils.FoodCardOutlinedTextField

@Composable
fun CardDetailsScreenRoot(
    viewModel: CardViewModel = CardViewModel(),
    onBackClick: () -> Unit = {}
) {
    val state by viewModel.state.collectAsState()

    CardDetailsScreen(
        state = state,
        onEvent = { action ->
            when (action) {
                CardDetailsAction.onCardSaved -> viewModel.onEvent(CardDetailsAction.onCardSaved)
                CardDetailsAction.onBackClick -> {
                    onBackClick()
                }

                is CardDetailsAction.UpdateCardHolderName -> viewModel.onEvent(action)
                is CardDetailsAction.UpdateCardNumber -> viewModel.onEvent(action)
                is CardDetailsAction.UpdateExpiryDate -> viewModel.onEvent(action)
                is CardDetailsAction.UpdateCvv -> viewModel.onEvent(action)
            }
        }
    )
}


@Composable
fun CardDetailsScreen(
    state: CardDetailsState,
    onEvent: (CardDetailsAction) -> Unit
) {
    Scaffold(
        containerColor = FoodBackGroundColor,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(FoodBackGroundColor),
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = { onEvent(CardDetailsAction.onBackClick) },
                        modifier = Modifier.padding(top = 10.dp)
                    ) {
                        Icon(
                            painterResource(Res.drawable.ic_back_arrow),
                            contentDescription = null
                        )
                    }
                }
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 15.dp)
                .fillMaxSize(),
        ) {
            Row(
                modifier = Modifier.padding(start = 10.dp, bottom = 18.dp)
            ) {
                Text(
                    stringResource(Res.string.credit_debit),
                    style = TextStyle.Default.copy(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = FoodTextPrimaryColor,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center
                    )
                )
            }
            BankCardUi(
                modifier = Modifier,
                baseColor = Color(0xFFFF9800),
                cardNumber = "4747  4747  4747  4747",
                cardHolder = "FULL NAME",
                expires = "MM/YY",
                cvv = "901",
                brand = "WISA"
            )
//            BankCardUi(
//                modifier = Modifier.padding(5.dp),
//                baseColor = Color(0xFFB993D6),
//                cardNumber = state.cardNumber.ifEmpty { "4747  4747  4747  4747" },
//                cardHolder = state.cardHolderName.ifEmpty { "FULL NAME" },
//                expires = state.expiryDate.ifEmpty { "MM/YY" },
//                cvv = state.cvv.ifEmpty { "CVC" },
//                brand = "YOUR BRAND"
//            )
            // Camera Scanner
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 160.dp, vertical = 1.dp)
                    .background(Color.Transparent)
                    .padding(16.dp)
            ) {
                Icon(
                    vectorResource(Res.drawable.ic_take_a_photo_icon),
                    tint = FoodTextSecondaryColor,
                    modifier = Modifier.background(FoodBackGroundColor)
                        .clickable {

                        },
                    contentDescription = null
                )
            }
            // Name on card input field
            FoodCardOutlinedTextField(
                value = state.cardHolderName,
                onValueChange = { newName -> onEvent(CardDetailsAction.UpdateCardHolderName(newName)) },
                startIcon = null,
                keyboardType = KeyboardType.Text,
                endIcon = null,
                title = stringResource(Res.string.name_on_card),
                hint = "Alexandra Smith",
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 5.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))

            // Card number input field
            FoodCardOutlinedTextField(
                value = state.cardNumber,
                onValueChange = { newNumber -> onEvent(CardDetailsAction.UpdateCardNumber(newNumber)) },
                startIcon = null,
                keyboardType = KeyboardType.Number,
                endIcon = painterResource(Res.drawable.ic_mc_symbol_img),
                hint = "4747  4747  4747  4747",
                title = stringResource(Res.string.card_number),
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 5.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))

            // Expiry date and CVC input fields
            Row(
                modifier = Modifier
                    .padding(horizontal = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                FoodCardOutlinedTextField(
                    value = state.expiryDate,
                    onValueChange = { newDate -> onEvent(CardDetailsAction.UpdateExpiryDate(newDate)) },
                    startIcon = null,
                    keyboardType = KeyboardType.Number,
                    endIcon = null,
                    hint = "MM/YY",
                    title = stringResource(Res.string.expiry_date),
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(15.dp))

                FoodCardOutlinedTextField(
                    value = state.cvv,
                    onValueChange = { newCVV -> onEvent(CardDetailsAction.UpdateCvv(newCVV)) },
                    startIcon = null,
                    keyboardType = KeyboardType.Number,
                    endIcon = painterResource(Res.drawable.ic_hint),
                    hint = "CVC",
                    title = stringResource(Res.string.cvc),
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            // Use this card button
            FoodButton(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 5.dp)
                    .height(56.dp),
                onClick = {},
                text = stringResource(Res.string.use_this_card)
            )
        }
    }
}
