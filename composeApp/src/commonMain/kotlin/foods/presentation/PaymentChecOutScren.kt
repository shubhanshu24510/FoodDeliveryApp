@file:OptIn(ExperimentalMaterial3Api::class)

package foods.presentation


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.ic_back_arrow
import fooddelivery.composeapp.generated.resources.ic_checj
import fooddelivery.composeapp.generated.resources.ic_credit_card_icon
import fooddelivery.composeapp.generated.resources.ic_home_icon
import fooddelivery.composeapp.generated.resources.ic_walking_iocn
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource


@Composable
fun CheckoutScreen() {
    val nonContactDelivery = remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
//                title = { Text(stringResource(Res.string)) },
                navigationIcon = {
                    IconButton(onClick = { /* handle back action */ }) {
                        Icon(
                            painterResource(Res.drawable.ic_back_arrow),
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        bottomBar = {
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Section(
                title = "Payment method",
                value = "**** **** **** 4747",
                icon = vectorResource(Res.drawable.ic_credit_card_icon),
                onChangeClick = { /* handle change payment method */ }
            )

            Section(
                title = "Delivery address",
                value = "Alexandra Smith\nCesu 31 k-2 5.st, SIA Chili\nRiga\nLV-1012\nLatvia",
                icon = vectorResource(Res.drawable.ic_home_icon),
                onChangeClick = { /* handle change address */ }
            )

            Section(
                title = "Delivery options",
                value = "By Drone",
                icon = null,
                onChangeClick = { /* handle change delivery options */ }
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    DeliveryOption(
                        "I'll pick it up myself", painterResource(Res.drawable.ic_walking_iocn,),
                        selected = true,
                    )

                }
            }

            NonContactDeliverySwitch(
                nonContactDelivery.value,
                onCheckedChange = { nonContactDelivery.value = it }
            )
        }
    }
}

@Composable
fun Section(
    title: String,
    value: String,
    icon: ImageVector?,
    onChangeClick: () -> Unit,
    content: @Composable (() -> Unit)? = null
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (icon != null) {
                    Icon(icon, contentDescription = null, modifier = Modifier.size(24.dp))
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(value, color = Color.Gray, fontSize = 14.sp)
                }
            }
            Text(
                text = "CHANGE",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable(onClick = onChangeClick)
            )
        }
        content?.invoke()
    }
}

@Composable
fun DeliveryOption(option: String, icon: Painter, selected: Boolean = false) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* handle selection */ }
            .background(if (selected) MaterialTheme.colorScheme.primary.copy(alpha = 0.1f) else Color.Transparent)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null, modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text(option, fontSize = 14.sp)
        if (selected) {
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(Res.drawable.ic_checj),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun NonContactDeliverySwitch(checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Non-contact-delivery", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Switch(
            checked = checked, onCheckedChange = onCheckedChange, colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.primary,
                uncheckedThumbColor = Color.Gray
            )
        )
    }
}

