package presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import components.FoodTopAppBar
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.ic_home_grid
import fooddelivery.composeapp.generated.resources.ic_shopping_cart
import fooddelivery.composeapp.generated.resources.ic_user
import fooddelivery.composeapp.generated.resources.vegetables
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun ItemScreen(modifier: Modifier = Modifier,
               tital: String = "") {
    Scaffold(
        topBar = {
            FoodTopAppBar(
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
        content = {

        },
    )

}