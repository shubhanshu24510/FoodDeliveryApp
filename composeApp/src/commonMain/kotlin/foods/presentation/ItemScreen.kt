package foods.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import designSystem.FoodBackGroundColor
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.ic_home_grid
import fooddelivery.composeapp.generated.resources.ic_shopping_cart
import fooddelivery.composeapp.generated.resources.ic_user
import fooddelivery.composeapp.generated.resources.vegetables
import foods.presentation.components.FoodItemCard
import foods.presentation.components.FoodTopAppBar
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun CategoryScreenRoot(
    onBackClick: () -> Unit = {},
    onCardClick: () -> Unit = {}
) {
    Scaffold(
        containerColor = FoodBackGroundColor,
        topBar = {
            FoodTopAppBar(
//                onSearchClick = {},
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
        content = {
//                FlowRow(
//                    horizontalArrangement = Arrangement.spacedBy(10.dp),
//                    verticalArrangement = Arrangement.spacedBy(10.dp),
//                    maxItemsInEachRow = 3,
//                    modifier = Modifier.background(FoodWhiteColor).
//                    padding(paddingValues = paddingValues
//                )) {
//                    Chip(
//                        text = "Oinons and garlic (8)",
//                        selected = true,
//                        onChipClick = {}
//                    )
//                }
            Column(
                modifier = Modifier
                    .padding(paddingValues = PaddingValues(top = 200.dp)),
            ) {

                LazyColumn {
                    items(10) {
                       FoodItemCard()
                    }
                }
            }
        },
    )
}