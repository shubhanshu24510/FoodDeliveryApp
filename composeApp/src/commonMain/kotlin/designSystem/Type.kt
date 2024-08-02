package designSystem

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.roboto_black
import fooddelivery.composeapp.generated.resources.roboto_bold
import fooddelivery.composeapp.generated.resources.roboto_light
import fooddelivery.composeapp.generated.resources.roboto_medium
import fooddelivery.composeapp.generated.resources.roboto_regular
import org.jetbrains.compose.resources.Font

@Composable
fun RobotoFontFamily() = FontFamily(
    Font(Res.font.roboto_light, weight = FontWeight.Light),
    Font(Res.font.roboto_regular, weight = FontWeight.Normal),
    Font(Res.font.roboto_medium, weight = FontWeight.Medium),
    Font(Res.font.roboto_bold, weight = FontWeight.SemiBold),
    Font(Res.font.roboto_bold, weight = FontWeight.Bold),
    Font(Res.font.roboto_black, weight = FontWeight.Black),
)

@Composable
fun Typography ()= Typography().run {

    val fontFamily = RobotoFontFamily()
    copy(
        displayLarge = displayLarge.copy(fontFamily = fontFamily),
        displayMedium = displayMedium.copy(fontFamily = fontFamily),
        displaySmall = displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = titleLarge.copy(fontFamily = fontFamily),
        titleMedium = titleMedium.copy(fontFamily = fontFamily),
        titleSmall = titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = bodyLarge.copy(fontFamily =  fontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = bodySmall.copy(fontFamily = fontFamily),
        labelLarge = labelLarge.copy(fontFamily = fontFamily),
        labelMedium = labelMedium.copy(fontFamily = fontFamily),
        labelSmall = labelSmall.copy(fontFamily = fontFamily
    )
    )
}