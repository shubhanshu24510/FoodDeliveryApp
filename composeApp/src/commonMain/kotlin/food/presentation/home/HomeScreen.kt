@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package food.presentation.home

import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import food.data.DestinationDataSource
import food.presentation.home.components.ItemLayout
import food.presentation.utils.FoodTopAppBar
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.categories
import fooddelivery.composeapp.generated.resources.ic_home_grid
import fooddelivery.composeapp.generated.resources.ic_shopping_cart
import fooddelivery.composeapp.generated.resources.ic_user
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun HomeScreenRoot(
    onCardClick: () -> Unit = {},
    onHomeClick: () -> Unit = {},
    onCartClick: () -> Unit = {},
    navController: NavController = rememberNavController()
) {
    Scaffold(
        topBar = {
            FoodTopAppBar(
                tital = stringResource(Res.string.categories),
                icon = null,
            )
        },
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
                            contentDescription = "Home"
                        )
                    }
                    IconButton(
                        onClick = { onCartClick() },
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
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues = PaddingValues(top = 200.dp)),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                val destinations = DestinationDataSource().loadData()
                val cellCount = 2
                LazyVerticalGrid(
                    columns = GridCells.Fixed(cellCount),
                    flingBehavior = ScrollableDefaults.flingBehavior(),
                    modifier = Modifier.padding(bottom = 90.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    contentPadding = PaddingValues(8.dp)
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
        },

        )
}

