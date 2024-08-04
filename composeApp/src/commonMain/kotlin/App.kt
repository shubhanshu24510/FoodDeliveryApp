import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import foods.presentation.CategoryScreenRoot
import foods.presentation.FoodDetailsScreen
import foods.presentation.SplashScreenRoot
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
      val navController = rememberNavController()
//        FoodDetailsScreen()
        CategoryScreenRoot()
//        NavigationRoot(navController)

    }
}
