import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import food.presentation.category.CategoryScreenRoot
import payment.presentation.checkout.CheckoutScreen
import food.presentation.details.FoodDetailsScreen
import food.presentation.home.HomeScreenRoot
import food.presentation.splash.SplashScreenRoot
import payment.presentation.creditCard.CardDetailsScreenRoot

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
                onCartClick = {
                    navController.navigate("Payment")
                },
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
                onHomeClick = {
                    navController.navigate("home")
                },
                onCartClick = {
                    navController.navigate("Payment")
                },
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
                onHomeClick = {
                    navController.navigate("home")
                },
                onCartClick = {
                    navController.navigate("Payment")
                },
                onChangeClick = {
                    navController.navigate("card")
                }
            )
        }
        composable(route = "card") {
            CardDetailsScreenRoot(
                onBackClick = {
                    navController.navigate("check")
                }
            )

        }
    }
}


