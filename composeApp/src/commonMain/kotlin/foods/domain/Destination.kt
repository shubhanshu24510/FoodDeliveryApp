package foods.domain

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class Destination(
    val nameItem: String,
    val photoItem: Painter,
//    val descriptionItem: String,
//    val countItem:Int,
//    val destinationId: UUID = UUID.randomUUID()
)
