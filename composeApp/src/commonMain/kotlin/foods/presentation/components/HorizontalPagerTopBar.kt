@file:OptIn(ExperimentalFoundationApi::class, ExperimentalLayoutApi::class)

package foods.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.ic_vegetable
import org.jetbrains.compose.resources.vectorResource
import kotlin.math.absoluteValue

@Composable
fun HorizontalPagerContent(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(pageCount = {
        4
    })
    HorizontalPager(state = pagerState) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(4.dp), // Add padding around the Card
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Image(
                vectorResource(Res.drawable.ic_vegetable),
                contentDescription = "Pager Image",
                contentScale = ContentScale.Crop, // Adjust as needed
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
        }
    }

}

