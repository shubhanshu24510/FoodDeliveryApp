import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import foods.presentation.CategoryScreenRoot
import foods.presentation.CheckoutScreen
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
        paymentGraph(navController)

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
                    navController.navigate("home") {
                        popUpTo("splash") {
                            inclusive = true
                        }
                    }
                },
                onOrderClick = {
                    navController.navigate("home") {
                        popUpTo("splash") {
                            inclusive = true
                        }
                    }
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
        composable(route = "Categaries") {
            CategoryScreenRoot(
                onBackClick = {
                    navController.navigate("home")
                },
                onCardClick = {
                    navController.navigate("details")
                }
            )
        }
        composable(route = "details") {
            FoodDetailsScreen(
                onPickCartClick = {
                    navController.navigate("Payment")
                }
            )
        }
    }
}


private fun NavGraphBuilder.paymentGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = "check", route = "Payment"
    ) {
        composable(route = "check") {
            CheckoutScreen(
            )
        }

        composable(route = "card") {

        }
    }
}


