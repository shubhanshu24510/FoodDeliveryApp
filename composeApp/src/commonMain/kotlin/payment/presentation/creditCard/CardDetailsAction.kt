@file:OptIn(ExperimentalFoundationApi::class)

package payment.presentation.creditCard

import androidx.compose.foundation.ExperimentalFoundationApi

sealed class CardDetailsAction {
    data class UpdateCardHolderName(val newName: String) : CardDetailsAction()
    data class UpdateCardNumber(val newNumber: String) : CardDetailsAction()
    data class UpdateExpiryDate(val newDate: String) : CardDetailsAction()
    data class UpdateCvv(val newCvv: String) : CardDetailsAction()
    object onCardSaved : CardDetailsAction()
    object onBackClick : CardDetailsAction()
}
