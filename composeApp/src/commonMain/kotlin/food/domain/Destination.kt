package food.domain

import org.jetbrains.compose.resources.DrawableResource

data class Destination(
    val imageRes: DrawableResource,
    val title: String,
    val quantity: String

)
data class ItemDestination(
    val imageRes: DrawableResource,
    val title: String,
    val price: String
)

