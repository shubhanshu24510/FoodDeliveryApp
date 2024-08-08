@file:OptIn(ExperimentalFoundationApi::class)

package payment.presentation.creditCard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CardViewModel : ViewModel() {
    private val _state = MutableStateFlow(CardDetailsState())
    val state: StateFlow<CardDetailsState> = _state

    fun onEvent(action: CardDetailsAction) {
        when (action) {
            is CardDetailsAction.UpdateCardHolderName -> {
                _state.update { it.copy(cardHolderName = action.newName) }
            }
            is CardDetailsAction.UpdateCardNumber -> {
                _state.update { it.copy(cardNumber = action.newNumber) }
            }
            is CardDetailsAction.UpdateExpiryDate -> {
                _state.update { it.copy(expiryDate = action.newDate) }
            }
            is CardDetailsAction.UpdateCvv -> {
                _state.update { it.copy(cvv = action.newCvv) }
            }
            // Handle other actions
            CardDetailsAction.onBackClick -> TODO()
            CardDetailsAction.onCardSaved -> TODO()
        }
    }
}