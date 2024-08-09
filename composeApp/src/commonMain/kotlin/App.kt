import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import food.presentation.category.CategoryScreenRoot
import food.presentation.details.FoodDetailsScreen
import food.presentation.home.HomeScreenRoot
import food.presentation.splash.SplashScreenRoot
import org.jetbrains.compose.ui.tooling.preview.Preview
import payment.presentation.checkout.CheckoutScreen
import payment.presentation.creditCard.CardDetailsScreenRoot

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
//        HomeScreenRoot()
//        HorizontalPagerTopBar()
//        FoodDetailsScreen()
//        CategoryScreenRoot()
//        CheckoutScreen()
        NavigationRoot(navController)
//        CardDetailsScreenRoot()
//        SplashScreenRoot()

    }
}
