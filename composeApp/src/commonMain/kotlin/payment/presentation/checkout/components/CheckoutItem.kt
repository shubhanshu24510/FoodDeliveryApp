package payment.presentation.checkout.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import designSystem.FoodBackGroundColor
import designSystem.FoodSelectedVioletColor
import designSystem.FoodTextPrimaryColor
import designSystem.FoodTextSecondaryColor
import designSystem.FoodWhiteColor
import designSystem.RobotoFontFamily
import fooddelivery.composeapp.generated.resources.Res
import fooddelivery.composeapp.generated.resources.change
import fooddelivery.composeapp.generated.resources.ic_checj
import fooddelivery.composeapp.generated.resources.non_contact_delivery
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun CardSection(
    title: String,
    initialValue: String = "",
    icon: ImageVector?,
    onChangeClick: () -> Unit = {},
    content: @Composable (() -> Unit)? = null
) {
    var isEditable by remember { mutableStateOf(false) }
    var textFieldValue by remember { mutableStateOf(initialValue) }

    Column(
        modifier = Modifier
    ) {
        //Payment Title
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            title,
                            style = TextStyle.Default.copy(
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = RobotoFontFamily(),
                                textAlign = TextAlign.Center,
                                color = FoodTextPrimaryColor
                            )
                        )
                        Text(
                            text = stringResource(Res.string.change),
                            style = TextStyle.Default.copy(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.ExtraBold,
                                fontFamily = FontFamily.SansSerif,
                                textAlign = TextAlign.Center,
                                color = FoodSelectedVioletColor
                            ),
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.clickable {
                                isEditable = !isEditable
                                onChangeClick()
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    //Payment Value
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (icon != null) {
                            Icon(
                                icon,
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                                    .align(Alignment.Top)
                            )
                        }
                        Spacer(modifier = Modifier.width(25.dp))
                        Box {
                            Text(
                                textFieldValue,
                                color = Color.Gray,
                                overflow = TextOverflow.Visible,
                                style = TextStyle.Default.copy(
                                    fontSize = 17.sp,
                                    lineHeight = TextUnit(25f, TextUnitType.Sp),
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = FontFamily.SansSerif,
                                    textAlign = TextAlign.Start,
                                    color = FoodTextSecondaryColor
                                ),
                            )

                        }
                    }
                }
            }
        }
        content?.invoke()
    }
}

@Composable
fun DeliveryOption(
    option: String,
    icon: Painter,
    selected: Boolean = false,
    onClick: () -> Unit
) {
//    var selected by rememberSaveable { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .background(FoodBackGroundColor)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = if (selected) FoodSelectedVioletColor else FoodTextSecondaryColor
        )

        Spacer(modifier = Modifier.width(25.dp))

        Text(
            text = option,
            style = TextStyle.Default.copy(
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                fontWeight = if(selected) FontWeight.SemiBold else FontWeight.Normal,
                color = if (selected) FoodSelectedVioletColor else FoodTextSecondaryColor
            )
        )

        if (selected) {
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(Res.drawable.ic_checj),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = FoodSelectedVioletColor
            )
        }
    }
}

@Composable
fun NonContactDeliverySwitch(
    modifier: Modifier
) {
    Row(
        modifier = modifier.padding(horizontal = 5.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(Res.string.non_contact_delivery),
            style = TextStyle.Default.copy(
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                color = FoodTextPrimaryColor,
            ),
            modifier = modifier
        )
        var checked by remember { mutableStateOf(true) }

        Switch(
            modifier = modifier
                .border(BorderStroke(width = 0.dp, color = Color.White))
                .semantics { contentDescription = "Demo with icon" },
            checked = checked,
            onCheckedChange = { checked = it },
            enabled = true,
            colors = SwitchDefaults.colors(FoodWhiteColor),
        )
    }
}

@Composable
fun CheckoutTitleOption(
    title: String,
    icon: ImageVector?,
    onChangeClick: () -> Unit,
    content: @Composable() (() -> Unit)? = null
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .padding(start = 10.dp)
    ) {
        Text(
            title,
            style = TextStyle.Default.copy(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                color = FoodTextPrimaryColor
            )
        )
        Text(
            text = stringResource(Res.string.change),
            style = TextStyle.Default.copy(
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                color = FoodSelectedVioletColor
            ),
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.clickable(onClick = onChangeClick)
        )
    }
}
