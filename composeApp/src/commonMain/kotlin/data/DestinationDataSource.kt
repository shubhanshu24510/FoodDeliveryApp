package data

import androidx.compose.runtime.Composable
import domain.Destination
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.bruits
import fooddelivery.composeapp.generated.resources.drinks
import fooddelivery.composeapp.generated.resources.fruits
import fooddelivery.composeapp.generated.resources.ic_bread
import fooddelivery.composeapp.generated.resources.ic_drinks
import fooddelivery.composeapp.generated.resources.ic_fruit
import fooddelivery.composeapp.generated.resources.ic_pasta
import fooddelivery.composeapp.generated.resources.ic_sweets
import fooddelivery.composeapp.generated.resources.ic_vegetable
import fooddelivery.composeapp.generated.resources.pasta
import fooddelivery.composeapp.generated.resources.sweets
import fooddelivery.composeapp.generated.resources.vegetables
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

class DestinationDataSource {
    @Composable
    fun loadData(): List<Destination> {
        return listOf(
            Destination(stringResource( Res.string.vegetables), painterResource(Res.drawable.ic_vegetable)),
            Destination(stringResource( Res.string.fruits), painterResource(Res.drawable.ic_fruit)),
            Destination(stringResource( Res.string.bruits), painterResource(Res.drawable.ic_bread)),
            Destination(stringResource( Res.string.sweets), painterResource(Res.drawable.ic_sweets)),
            Destination(stringResource( Res.string.pasta), painterResource(Res.drawable.ic_pasta)),
            Destination(stringResource( Res.string.drinks), painterResource(Res.drawable.ic_drinks))
        )
    }
}