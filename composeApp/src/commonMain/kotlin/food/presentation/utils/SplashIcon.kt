package food.presentation.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.ic_splash
import org.jetbrains.compose.resources.painterResource

@Composable
fun SplashIcon(modifier: Modifier) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(
                Color.White
            )
            .size(104.dp),
        contentAlignment = Alignment.Center
    )
    {
        Image(
            painter = painterResource(Res.drawable.ic_splash),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.Fit,
            modifier = Modifier.align(Alignment.Center)
        )

    }
}