@file:OptIn(ExperimentalLayoutApi::class)

package foods.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import designSystem.FoodBackGroundColor
import designSystem.FoodWhiteColor
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.ic_home_grid
import fooddelivery.composeapp.generated.resources.ic_shopping_cart
import fooddelivery.composeapp.generated.resources.ic_user
import fooddelivery.composeapp.generated.resources.ic_vegetable
import fooddelivery.composeapp.generated.resources.vegetables
import foods.presentation.components.Chip
import foods.presentation.components.ChipSelector
import foods.presentation.components.FoodItemCard
import foods.presentation.components.FoodTopAppBar
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun CategoryScreenRoot(
    onBackClick: () -> Unit = {},
    onCardClick: () -> Unit = {},
    onSearchClick: () -> Unit = {}
) {
    val textChipRememberOneState = remember {
        mutableStateOf(false)
    }
    Scaffold(
        containerColor = FoodBackGroundColor,
        topBar = {
            FoodTopAppBar(
                onSearchClick = {},
                onBackClick = onBackClick,
                tital = stringResource(Res.string.vegetables)
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
                            contentDescription = "Share contact"
                        )
                    }
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(horizontal = 40.dp)
                    ) {
                        Icon(
                            imageVector = vectorResource(Res.drawable.ic_shopping_cart),
                            contentDescription = "Mark as favorite"
                        )
                    }
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(horizontal = 40.dp)
                    ) {
                        Icon(
                            imageVector = vectorResource(Res.drawable.ic_user),
                            contentDescription = "Email contact"
                        )
                    }
                },
            )

        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues = PaddingValues(top = 200.dp)),
            ) {
                FlowRow(
                    modifier = Modifier.padding(horizontal = 5.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    ChipSelector(
                        isSelected = false,
                        text = "Сabbage and lettuce (14)",
                        onChecked = {
                            textChipRememberOneState.value = it
                        }
                    )
                }
                LazyColumn {
                    items(10) {
                        FoodItemCard(
                            onClick = onCardClick
                        )
                    }
                }
            }
        },
    )
}