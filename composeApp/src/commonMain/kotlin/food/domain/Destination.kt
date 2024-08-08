package food.domain

import org.jetbrains.compose.resources.DrawableResource

data class Destination(
    val imageRes: DrawableResource,
    val title: String
)
data class ItemDestination(
    val imageRes: DrawableResource,
    val title: String
)

//data class Destination(
//    val nameItem: String,
//    val photoItem: Painter,
////    val descriptionItem: String,
////    val countItem:Int,
////    val destinationId: UUID = UUID.randomUUID()
//)
