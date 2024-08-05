import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import foods.presentation.CheckoutScreen
import foods.presentation.FoodDetailsScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
      val navController = rememberNavController()
//        HorizontalPagerTopBar()
//        FoodDetailsScreen()
//        CategoryScreenRoot()
//        NavigationRoot(navController)
        CheckoutScreen()

    }
}
