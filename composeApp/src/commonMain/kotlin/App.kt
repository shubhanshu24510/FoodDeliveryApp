import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import foods.presentation.CheckoutScreen
import foods.presentation.FoodDetailsScreen
import foods.presentation.HomeScreenRoot
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
      val navController = rememberNavController()
//        HomeScreenRoot()
//        HorizontalPagerTopBar()
//        FoodDetailsScreen()
//        CategoryScreenRoot()
        NavigationRoot(navController)
//        CheckoutScreen()

    }
}
