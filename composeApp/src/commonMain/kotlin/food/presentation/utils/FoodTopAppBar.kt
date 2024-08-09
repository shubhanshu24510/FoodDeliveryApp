package food.presentation.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import designSystem.FoodTextPrimaryColor

@Composable
fun FoodTopAppBar(
    title: String = "",
    onBackClick: () -> Unit = {},
    icon: ImageVector,
    modifier: Modifier,
    onSearchClick: () -> Unit = {}
) {
    Icon(
        imageVector = icon,
        contentDescription = null,
        tint = FoodTextPrimaryColor,
        modifier = modifier
            .clickable {
                onBackClick()
            }
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
    )
    FoodTitelText(
        name = title,
        modifier = Modifier
            .padding(horizontal = 10.dp)

    )
    FoodOutlinedSearchTextField(
        modifier = Modifier
            .padding(
                horizontal = 20.dp, vertical = 10.dp
            ),
        onSearchClick = onSearchClick
    )
}
