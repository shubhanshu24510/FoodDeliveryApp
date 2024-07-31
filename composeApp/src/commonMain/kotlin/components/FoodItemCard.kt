package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.boston_lettuce
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun FoodItemCard(modifier: Modifier = Modifier) {
    Box(modifier= Modifier.fillMaxWidth()
        .height(160.dp)) {
        Row(modifier= Modifier
            .size(width = 177.dp, height = 128.dp)) {
            Image(painter = painterResource(Res.drawable.boston_lettuce),
                contentDescription = null,)

            Column {
                Text(stringResource(Res.string.boston_lettuce))
                Text("$1.10 € / piece")
                
            }

        }


    }


}

@Composable
fun FoodButtonCard(modifier: Modifier = Modifier) {

    
}