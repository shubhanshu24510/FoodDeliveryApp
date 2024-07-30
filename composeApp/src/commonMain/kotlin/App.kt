import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.HomeScreen
import presentation.SplashScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
//        SplashScreen()
        HomeScreen()
    }
}