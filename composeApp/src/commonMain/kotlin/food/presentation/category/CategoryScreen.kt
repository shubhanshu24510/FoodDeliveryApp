@file:OptIn(ExperimentalLayoutApi::class)

package food.presentation.category

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
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
import food.data.ItemDestinationDataSources
import food.data.filterItemNames
import food.presentation.category.components.FoodFilterChip
import food.presentation.utils.FoodItemCard
import food.presentation.utils.FoodTopAppBar
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.ic_back_arrow
import fooddelivery.composeapp.generated.resources.ic_home_grid
import fooddelivery.composeapp.generated.resources.ic_image_boston
import fooddelivery.composeapp.generated.resources.ic_image_cabbage
import fooddelivery.composeapp.generated.resources.ic_image_cultiflower
import fooddelivery.composeapp.generated.resources.ic_shopping_cart
import fooddelivery.composeapp.generated.resources.ic_user
import fooddelivery.composeapp.generated.resources.vegetables
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun CategoryScreenRoot(
    onBackClick: () -> Unit = {},
    onCardClick: () -> Unit = {},
    onSearchClick: () -> Unit = {},
    onCartClick: () -> Unit = {},
    onHomeClick: () -> Unit = {},
) {
    remember {
        mutableStateOf(false)
    }
    val imageResources = listOf(
        Res.drawable.ic_image_boston,
        Res.drawable.ic_image_cabbage,
        Res.drawable.ic_image_cultiflower,
    )
    Scaffold(
        topBar = {
            FoodTopAppBar(
                tital = stringResource(Res.string.vegetables),
                icon = vectorResource(Res.drawable.ic_back_arrow),
                onBackClick = onBackClick,
                onSearchClick = onSearchClick
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
        content = { paddingValues ->
            val destinations = ItemDestinationDataSources().loadData()

            Column(
                modifier = Modifier
                    .background(FoodBackGroundColor)
                    .padding(paddingValues = PaddingValues(top = 200.dp)),
            ) {
                FlowRow {
                    LazyRow {
                        items(filterItemNames.size) { index ->
                            FoodFilterChip(
                                itemsName = filterItemNames[index]
                            )
                        }
                    }
                }
                LazyColumn(
                    modifier = Modifier.padding(bottom = 80.dp)
                ) {
                    itemsIndexed(destinations) { index, destination ->
                        FoodItemCard(
                            destination,
                            onClick = onCardClick,
                        )

                    }
                }
            }
        },
    )
}
