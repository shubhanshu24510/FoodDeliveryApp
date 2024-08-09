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
            Destination(imageRes = Res.drawable.ic_vegetable, title = "Vegetables", quantity = "(43)"),
            Destination(imageRes = Res.drawable.ic_fruit, title = "Fruits", quantity = "(32)"),
            Destination(imageRes = Res.drawable.ic_bread, title = "Bread", quantity = "(22)"),
            Destination(imageRes = Res.drawable.ic_sweets, title = "Sweets", quantity = "(56)"),
            Destination(imageRes = Res.drawable.ic_pasta, title = "Pasta", quantity = "(20)"),
            Destination(imageRes = Res.drawable.ic_drinks, title = "Drinks", quantity = "(13)"),
        )
    }
}

class ItemDestinationDataSources {
    fun loadData(): List<ItemDestination> {
        return listOf(
            ItemDestination(imageRes = Res.drawable.ic_image_boston, title = "Boston Lettuce", price = "1.10"),
            ItemDestination(imageRes = Res.drawable.ic_image_cabbage, title = "Purple Cauliflower","1.85"),
            ItemDestination(imageRes = Res.drawable.ic_image_cultiflower, title = "Savoy Cabbage","1.45"),
        )
    }
}

