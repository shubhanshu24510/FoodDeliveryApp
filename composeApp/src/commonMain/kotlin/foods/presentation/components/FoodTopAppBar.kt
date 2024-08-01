package foods.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.ic_back_arrow
import org.jetbrains.compose.resources.vectorResource

@Composable
fun FoodTopAppBar(
    tital: String = "",
    onBackClick: () -> Unit = {},
//    onSearchClick: () -> Unit ={}
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        IconButton(
            onClick = onBackClick,
            content = {
                Icon(
                    imageVector = vectorResource(Res.drawable.ic_back_arrow),
                    contentDescription = null
                )
            }
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = tital,
            fontSize = 30.sp,
            modifier = Modifier.padding(horizontal = 18.dp),
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(30.dp))
        FoodOutlinedSearchTextField(
//            onSearchClick = onSearchClick
        )
    }
}
