@file:OptIn(ExperimentalMaterial3Api::class)

package foods.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.boston_lettuce
import fooddelivery.composeapp.generated.resources.ic_vegetable
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

data class Product(
    val name: String,
    val price: String,
    val imageRes: DrawableResource
)

@Composable
fun VegetableScreen(

) {
    val products = remember {
        listOf(
            Product("Boston Lettuce", "1.10 € / piece", Res.drawable.boston_lettuce),
            Product("Purple Cauliflower", "1.85 € / kg", Res.drawable.boston_lettuce),
            Product("Savoy Cabbage", "1.45 € / kg",Res.drawable.boston_lettuce)
        )
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Vegetables") }) }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            SearchBar()
            CategoryChips()
            ProductList(products)
        }
    }
}

@Composable
fun SearchBar() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        placeholder = { Text("Search") },
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = null)
        },
        shape = CircleShape
    )
}

@Composable
fun CategoryChips() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        listOf(
            "Cabbage and lettuce (14)" to true,
            "Cucumbers and tomatoes",
            "Onions and garlic (8)",
            "Peppers (7)",
            "Potatoes and carrots")
//        ).forEach { (category, selected) ->
//            FilterChip(
//                selected = selected,
//                onClick = { /* TODO: Handle click */ },
//                label = { Text(text = category) }
//            )
//        }
    }
}

@Composable
fun ProductList(products: List<Product>) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(products) { product ->
            ProductCard(product)
        }
    }
}

@Composable
fun ProductCard(product: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* TODO: Handle click */ },
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(Res.drawable.ic_vegetable),
                contentDescription = product.name,
                modifier = Modifier
                    .size(64.dp)
                    .padding(end = 16.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = product.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Text(
                    text = product.price,
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
            IconButton(onClick = { /* TODO: Handle wishlist click */ }) {
                Icon(Icons.Default.FavoriteBorder, contentDescription = null)
            }
            IconButton(onClick = { /* TODO: Handle add to cart click */ }) {
                Icon(Icons.Default.ShoppingCart, contentDescription = null)
            }
        }
    }
}
