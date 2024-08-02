import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import foods.presentation.CategoryScreenRoot
import foods.presentation.FoodDetailsScreen
import foods.presentation.HomeScreenRoot
import foods.presentation.SplashScreenRoot

@Composable
fun NavigationRoot(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "food"
    ) {
        foodGraph(navController)
    }
}

private fun NavGraphBuilder.foodGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = "splash", route = "food"
    ) {
        composable(route = "splash") {
            SplashScreenRoot(
                onDismissClick = {
                    navController.navigate("home")
                },
                onOrderClick = {
                    navController.navigate("home")
                },
            )
        }
        composable(route = "home") {
            HomeScreenRoot(
                onHomeClick = {
                    navController.navigate("home")
                },
                onCardClick = {
                    navController.navigate("categaries")
                },
            )
        }
        composable(route = "details") {
           FoodDetailsScreen()
        }
        composable(route = "Categaries"){
            CategoryScreenRoot(
                onBackClick = {
                    navController.navigate("home")
                },
                onCardClick = {
                    navController.navigate("details")
                }
            )
        }
    }
}
