package designSystem

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

val DarkColorScheme = darkColorScheme(
    primary = FoodWhiteColor,
    background = FoodBackGroundColor,
    primaryContainer = FoodPrimaryButtonColor,
    secondary = FoodWhiteColor,
    onPrimaryContainer =FoodBorderColor ,
    onSecondaryContainer = FoodSelectedBackgroundViolet,
    onPrimary = FoodTextPrimaryColor,
    onSecondary = FoodTextSecondaryColor,
    onTertiary = FoodSelectedVioletColor,
    tertiary = FoodGreenColor,
)

@Composable
fun FoodTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        content = content,
        typography = Typography
    )
}