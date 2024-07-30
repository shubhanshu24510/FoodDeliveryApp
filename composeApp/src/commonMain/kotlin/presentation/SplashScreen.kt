@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class
)

package presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.dismiss
import fooddelivery.composeapp.generated.resources.ic_splash
import fooddelivery.composeapp.generated.resources.order_now
import fooddelivery.composeapp.generated.resources.splash_des
import fooddelivery.composeapp.generated.resources.splash_ti
import fooddelivery.composeapp.generated.resources.splash_tiii
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun SplashScreen(
    onOrderClick: () -> Unit = {},
    onDismissClick: () -> Unit = {}
) {
    val modelBottomSheetState = rememberModalBottomSheetState()
    var shoeSheet by remember { mutableStateOf(true) }
    ModalBottomSheet(
        sheetState = modelBottomSheetState,
        onDismissRequest = {},
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight(),
        shape = RoundedCornerShape(40.dp),
        windowInsets = BottomSheetDefaults.windowInsets,
        dragHandle = { BottomSheetDefaults.DragHandle() },
        containerColor = Color(0xFFF6F5F5),
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 2.dp)
            ) {
                SplashIcon(modifier = Modifier)

                Column(modifier = Modifier.padding(top = 1.dp)) {
                    Text(
                        stringResource(Res.string.splash_ti),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = TextUnit(0.5f, TextUnitType.Sp),
                        modifier = Modifier.padding(horizontal = 50.dp, vertical = 2.dp),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        stringResource(Res.string.splash_tiii),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = TextUnit(0.5f, TextUnitType.Sp),
                        modifier = Modifier.padding(horizontal = 70.dp, vertical = 2.dp),
                        textAlign = TextAlign.Center
                    )
                }
                Box(modifier = Modifier.padding(top = 1.dp)) {
                    Text(
                        stringResource(Res.string.splash_des),
                        fontSize = 13.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        softWrap = true,
                        modifier = Modifier.padding(horizontal = 50.dp),
                        textAlign = TextAlign.Center,
                    )
                }
                FoodButton(
                    onClick = onOrderClick
                )

                Row(
                    modifier = Modifier.padding(horizontal = 50.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OneTimeClickableText(
                        text = stringResource(Res.string.dismiss),
                        onClick = {
                           onDismissClick()
                        }
                    )

                    }
            }
        },
    )
}

@Preview()
@Composable
fun SplashScreenPreview(modifier: Modifier = Modifier) {
    MaterialTheme {
        SplashScreen()
    }
}

@Composable
fun SplashIcon(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(
                Color.White
            )
            .size(80.dp),
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

@Composable
fun FoodButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(size = 8.dp),
        modifier = Modifier.width(374.dp)
            .height(56.dp)
            .padding(horizontal = 30.dp, vertical = 5.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF0BCE83)),
        content = {
            Text(stringResource(Res.string.order_now))
        }
    )
}

@Composable
fun OneTimeClickableText(text : String, onClick : () -> Unit){
    var enabled by rememberSaveable{ mutableStateOf(true)}
    Text(
        modifier = Modifier
            .clickable(enabled = enabled) {
                enabled = false
                onClick()
            },
        style = TextStyle.Default.copy(
            color = Color(0xFF9586A8),
        ),
        textAlign = TextAlign.Center,
        fontSize = 13.sp,
        fontWeight = FontWeight.ExtraBold,
        text = text,
    )
}
