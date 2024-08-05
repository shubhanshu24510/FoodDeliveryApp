@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package foods.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.traceEventEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import designSystem.FoodTextPrimaryColor
import designSystem.FoodTextSecondaryColor
import designSystem.RobotoFontFamily
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.categories
import fooddelivery.composeapp.generated.resources.ic_home_grid
import fooddelivery.composeapp.generated.resources.ic_shopping_cart
import fooddelivery.composeapp.generated.resources.ic_user
import fooddelivery.composeapp.generated.resources.ic_vegetable
import fooddelivery.composeapp.generated.resources.quantity
import fooddelivery.composeapp.generated.resources.vegetables
import foods.data.DestinationDataSource
import foods.domain.Destination
import foods.presentation.components.FoodTopAppBar
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun HomeScreenRoot(
    onCardClick: () -> Unit = {},
    onHomeClick: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            FoodTopAppBar(
                tital = stringResource(Res.string.categories),
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
                    reverseLayout = true,
                    flingBehavior = ScrollableDefaults.flingBehavior(),
                    modifier = Modifier.padding(bottom = 70.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    userScrollEnabled = true,
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    contentPadding = PaddingValues(8.dp)
                ) {
                    itemsIndexed(destinations) { index, destination ->
                        Row(Modifier.padding(8.dp)) {
                            ItemLayout(
                                destination, index,
                                onCardClick = onCardClick
                            )
                        }
                    }
                }
            }
        },

        )
}

@Composable
fun CardItems(
    modifier: Modifier = Modifier,
    itemName: String = "",
    itemImage: String = "",
    onClick: () -> Unit = {}
) {
    Box {
        Card(
            modifier = Modifier
                .size(width = 177.dp, height = 211.dp)
                .clickable { onClick() },
            shape = RoundedCornerShape(8.dp)

        ) {
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(stringResource(Res.string.vegetables))
            }
        }
    }
}


@Composable
fun ItemLayout(
    destination: Destination,
    index: Int,
    onCardClick: () -> Unit = {}
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxWidth()
    ) {
        Card(
            modifier = Modifier.size(width = 177.dp, height = 211.dp)
                .clickable {
                    onCardClick()
                },
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Image(
//                painter = itemImage,
                painter = painterResource(Res.drawable.ic_vegetable),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
                    .size(width = 177.dp, height = 140.dp),
                contentScale = ContentScale.Fit
            )
          FoodItemTitalText(name = stringResource(Res.string.vegetables))
            FoodItemQuantityText(
                name = stringResource(Res.string.quantity),
            )
        }

    }
}

@Composable
fun FoodItemTitalText(
    modifier: Modifier = Modifier,
    name: String,
) {
    Text(
        text = name,
        color = FoodTextPrimaryColor,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        softWrap = true,
        fontSize = 18.sp,
        fontFamily = RobotoFontFamily(),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    )
}
@Composable
fun FoodItemQuantityText(
    modifier: Modifier = Modifier,
    name: String,
) {
    Text(
        text = name,
        color = FoodTextSecondaryColor,
        textAlign = TextAlign.Center,
        fontSize = 12.sp,
        fontFamily = RobotoFontFamily(),
        fontWeight = FontWeight.Light,
        modifier = Modifier.padding(horizontal = 10.dp)
    )
}