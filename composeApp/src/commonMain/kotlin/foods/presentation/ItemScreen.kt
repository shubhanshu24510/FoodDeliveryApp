@file:OptIn(ExperimentalLayoutApi::class)

package foods.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import designSystem.FoodBackGroundColor
import designSystem.FoodSelectedVioletColor
import designSystem.FoodTextSecondaryColor
import designSystem.FoodWhiteColor
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.ic_back_arrow
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
                icon = vectorResource(Res.drawable.ic_back_arrow),
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
                FlowRow {
                    LazyRow {
                        items(5){
                            FoodFilterChip(
                                itemsName = "Сabbage and lettuce (14)"
                            )
                        }

                    }
                }
                LazyColumn(
                    modifier = Modifier.padding(bottom = 80.dp)
                ) {
                    items(10) {
                        FoodItemCard(
                            onClick = onCardClick,
                        )
                    }
                }
            }
        },
    )
}

@Composable
fun FoodFilterChip(
    itemsName: String
) {
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        onClick = { selected = !selected },
        label = {
            Text(
                text = itemsName,
                color = if (selected) FoodSelectedVioletColor else FoodTextSecondaryColor
            )
        },
        border = BorderStroke(
            width = 1.dp,
            color = FoodWhiteColor,
        ),
        colors = FilterChipDefaults.filterChipColors(if (selected) FoodSelectedVioletColor else FoodWhiteColor),
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(percent = 50),
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
    )
}

@Composable
fun ChipVerticalGrid(
    modifier: Modifier = Modifier,
    spacing: Dp,
    moreItemsView: @Composable (Int) -> Unit,
    content: @Composable () -> Unit,
) {
    SubcomposeLayout(
        modifier = modifier
    ) { constraints ->
        val contentConstraints = constraints.copy(minWidth = 0, minHeight = 0)
        var currentRow = 0
        var currentOrigin = IntOffset.Zero
        val spacingValue = spacing.toPx().toInt()
        val mainMeasurables = subcompose("content", content)
        val placeables = mutableListOf<Pair<Placeable, IntOffset>>()
        for (i in mainMeasurables.indices) {
            val measurable = mainMeasurables[i]
            val placeable = measurable.measure(contentConstraints)

            fun Placeable.didOverflowWidth() =
                currentOrigin.x > 0f && currentOrigin.x + width > contentConstraints.maxWidth

            if (placeable.didOverflowWidth()) {
                currentRow += 1
                val nextRowOffset = currentOrigin.y + placeable.height + spacingValue

                if (nextRowOffset + placeable.height > contentConstraints.maxHeight) {
                    var morePlaceable: Placeable
                    do {
                        val itemsLeft = mainMeasurables.count() - placeables.count()

                        morePlaceable = subcompose(itemsLeft) {
                            moreItemsView(itemsLeft)
                        }[0].measure(contentConstraints)
                        val didOverflowWidth = morePlaceable.didOverflowWidth()
                        if (didOverflowWidth) {
                            val removed = placeables.removeLast()
                            currentOrigin = removed.second
                        }
                    } while (didOverflowWidth)
                    placeables.add(morePlaceable to currentOrigin)
                    break
                }
                currentOrigin = currentOrigin.copy(x = 0, y = nextRowOffset)
            }

            placeables.add(placeable to currentOrigin)
            currentOrigin = currentOrigin.copy(x = currentOrigin.x + placeable.width + spacingValue)
        }
        layout(
            width = maxOf(
                constraints.minWidth,
                placeables.maxOfOrNull { it.first.width + it.second.x } ?: 0),
            height = maxOf(
                constraints.minHeight,
                placeables.lastOrNull()?.run { first.height + second.y } ?: 0),
        ) {
            placeables.forEach {
                val (placeable, origin) = it
                placeable.place(origin.x, origin.y)
            }
        }
    }
}


