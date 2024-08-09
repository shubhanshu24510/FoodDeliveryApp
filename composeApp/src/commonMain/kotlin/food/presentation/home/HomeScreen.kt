@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package food.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.AppBarDefaults
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import designSystem.FoodBackGroundColor
import designSystem.FoodTextPrimaryColor
import food.data.DestinationDataSource
import food.presentation.home.components.ItemLayout
import food.presentation.utils.FoodOutlinedSearchTextField
import food.presentation.utils.FoodTitelText
import food.presentation.utils.FoodTopAppBar
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.categories
import fooddelivery.composeapp.generated.resources.ic_back_arrow
import fooddelivery.composeapp.generated.resources.ic_home_grid
import fooddelivery.composeapp.generated.resources.ic_shopping_cart
import fooddelivery.composeapp.generated.resources.ic_user
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import payment.presentation.creditCard.CardDetailsAction

@Composable
fun HomeScreenRoot(
    onCardClick: () -> Unit = {},
    onHomeClick: () -> Unit = {},
    onCartClick: () -> Unit = {},
    onSearchClick: () -> Unit = {}
) {
    Scaffold(
        containerColor = FoodBackGroundColor,
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White,
                actions = {
                    IconButton(
                        onClick = onHomeClick,
                        modifier = Modifier.padding(horizontal = 40.dp)
                    ) {
                        Icon(
                            imageVector = vectorResource(Res.drawable.ic_home_grid),
                            contentDescription = null
                        )
                    }
                    IconButton(
                        onClick = { onCartClick() },
                        modifier = Modifier.padding(horizontal = 40.dp)
                    ) {
                        Icon(
                            imageVector = vectorResource(Res.drawable.ic_shopping_cart),
                            contentDescription = null
                        )
                    }
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(horizontal = 40.dp)
                    ) {
                        Icon(
                            imageVector = vectorResource(Res.drawable.ic_user),
                            contentDescription = null
                        )
                    }
                },
            )

        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FoodTopAppBar(
                title = stringResource(Res.string.categories),
                icon = vectorResource(Res.drawable.ic_back_arrow),
                onBackClick = {},
                onSearchClick = onSearchClick,
                modifier = Modifier
            )
            val destinations = DestinationDataSource().loadData()
            val cellCount = 2
            LazyVerticalGrid(
                columns = GridCells.Fixed(cellCount),
                flingBehavior = ScrollableDefaults.flingBehavior(),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp),
                contentPadding = PaddingValues(10.dp)
            ) {
                itemsIndexed(destinations) { index, destination ->
                    Row(Modifier.padding(8.dp)) {
                        ItemLayout(
                            destination,
                            onCardClick = onCardClick
                        )
                    }
                }
            }
        }
    }
}


