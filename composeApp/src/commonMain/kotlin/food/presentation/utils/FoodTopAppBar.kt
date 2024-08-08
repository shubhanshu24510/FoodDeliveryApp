package food.presentation.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import designSystem.FoodBackGroundColor

@Composable
fun FoodTopAppBar(
    tital: String = "",
    onBackClick: () -> Unit = {},
    icon: ImageVector?,
    onSearchClick: () -> Unit ={}
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        IconButton(
            onClick = onBackClick,
            content = {
                if (icon != null) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(15.dp))
        FoodTitalText(
            padding = PaddingValues(horizontal = 15.dp),
            name =tital,
        )

        Spacer(modifier = Modifier.height(30.dp))
        FoodOutlinedSearchTextField(
            onSearchClick = onSearchClick
        )
    }
}
