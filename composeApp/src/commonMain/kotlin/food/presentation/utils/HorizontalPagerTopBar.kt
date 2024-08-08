@file:OptIn(ExperimentalFoundationApi::class, ExperimentalLayoutApi::class)

package food.presentation.utils

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import designSystem.FoodBackGroundColor
import designSystem.FoodWhiteColor
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.ic_vegetable
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun HorizontalPagerContent() {
        val pageCount = 3
        val pagerState = rememberPagerState(
            pageCount = { pageCount },
        )
        val indicatorScrollState = rememberLazyListState()

        LaunchedEffect(key1 = pagerState.currentPage, block = {
            val currentPage = pagerState.currentPage
            val size = indicatorScrollState.layoutInfo.visibleItemsInfo.size
            val lastVisibleIndex =
                indicatorScrollState.layoutInfo.visibleItemsInfo.last().index
            indicatorScrollState.firstVisibleItemIndex

            if (currentPage > lastVisibleIndex - 1) {
                indicatorScrollState.animateScrollToItem(currentPage - size + 2)
            }
        })
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                    Image(
                        painter = painterResource(Res.drawable.ic_vegetable),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        alpha = DefaultAlpha,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.align(Alignment.BottomCenter)
                    .padding(bottom = 19.dp)
            ) {
                LazyRow(
                    state = indicatorScrollState,
                    modifier = Modifier
                        .height(20.dp)
                        .width(((6 + 16) * 2 + 3 * (10 + 16)).dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(pageCount) { iteration ->
                        val color =
                            if (pagerState.currentPage == iteration) FoodWhiteColor else FoodBackGroundColor
                        item(key = "item$iteration") {
                            val currentPage = pagerState.currentPage
                            val firstVisibleIndex by remember { derivedStateOf { indicatorScrollState.firstVisibleItemIndex } }
                            val lastVisibleIndex =
                                indicatorScrollState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
                                    ?: 0
                            val size by animateDpAsState(
                                targetValue = if (iteration == currentPage) {
                                    7.dp
                                } else if (iteration in firstVisibleIndex + 1..lastVisibleIndex - 1) {
                                    6.dp
                                } else {
                                    4.dp
                                }
                            )
                            Box(
                                modifier = Modifier
                                    .padding(3.dp)
                                    .background(color, CircleShape)
                                    .size(
                                        size
                                    )
                            )
                        }
                    }
                }
            }
        }
    }
//}