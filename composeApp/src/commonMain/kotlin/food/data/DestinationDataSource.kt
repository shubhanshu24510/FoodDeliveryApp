package food.data

import food.domain.Destination
import food.domain.ItemDestination
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.ic_bread
import fooddelivery.composeapp.generated.resources.ic_drinks
import fooddelivery.composeapp.generated.resources.ic_fruit
import fooddelivery.composeapp.generated.resources.ic_image_boston
import fooddelivery.composeapp.generated.resources.ic_image_cabbage
import fooddelivery.composeapp.generated.resources.ic_image_cultiflower
import fooddelivery.composeapp.generated.resources.ic_pasta
import fooddelivery.composeapp.generated.resources.ic_sweets
import fooddelivery.composeapp.generated.resources.ic_vegetable


class DestinationDataSource {
    fun loadData(): List<Destination> {
        return listOf(
            Destination(imageRes = Res.drawable.ic_vegetable, title = "Vegetables"),
            Destination(imageRes = Res.drawable.ic_fruit, title = "Fruits"),
            Destination(imageRes = Res.drawable.ic_bread, title = "Bread"),
            Destination(imageRes = Res.drawable.ic_sweets, title = "Sweets"),
            Destination(imageRes = Res.drawable.ic_pasta, title = "Pasta"),
            Destination(imageRes = Res.drawable.ic_drinks, title = "Drinks"),
        )
    }
}

class ItemDestinationDataSources {
    fun loadData(): List<ItemDestination> {
        return listOf(
            ItemDestination(imageRes = Res.drawable.ic_image_boston, title = "Boston Lettuce"),
            ItemDestination(imageRes = Res.drawable.ic_image_cabbage, title = "Purple Cauliflower"),
            ItemDestination(imageRes = Res.drawable.ic_image_cultiflower, title = "Savoy Cabbage"),
        )
    }
}
//class DestinationDataSource {
//    @Composable
//    fun loadData(): List<Destination> {
//        return listOf(
//            Destination(stringResource( Res.string.vegetables), painterResource(Res.drawable.ic_vegetable)),
//            Destination(stringResource( Res.string.fruits), painterResource(Res.drawable.ic_fruit)),
//            Destination(stringResource( Res.string.bruits), painterResource(Res.drawable.ic_bread)),
//            Destination(stringResource( Res.string.sweets), painterResource(Res.drawable.ic_sweets)),
//            Destination(stringResource( Res.string.pasta), painterResource(Res.drawable.ic_pasta)),
//            Destination(stringResource( Res.string.drinks), painterResource(Res.drawable.ic_drinks))
//        )
//    }
//}

