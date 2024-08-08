@file:OptIn(ExperimentalFoundationApi::class)

package payment.presentation.utils

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import designSystem.FoodBorderColor
import designSystem.FoodTextPrimaryColor
import designSystem.FoodTextSecondaryColor
import designSystem.FoodWhiteColor
import designSystem.RobotoFontFamily

@Composable
fun FoodCardOutlinedTextField(
    value: String = "",
    onValueChange: (String) -> Unit = {},
    startIcon: ImageVector?,
    endIcon: Painter?,
    title: String?,
    hint: String,
    addInfo: String? = null,
    error: String? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    modifier: Modifier = Modifier
) {
    var isFocused by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .padding(start = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (title != null) {
                Text(
                    text = title,
                    fontSize = 14.sp,
                    fontFamily = RobotoFontFamily(),
                    fontWeight = FontWeight.Normal,
                    color = FoodTextSecondaryColor
                )
            }
            if (error != null) {
                Text(
                    text = error,
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 12.sp
                )
            } else if (addInfo != null) {
                Text(
                    text = addInfo,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 12.sp
                )
            }

        }
        BasicTextField2(
            value =value,
            onValueChange = {
                onValueChange(it)
            },
            textStyle = LocalTextStyle.current.copy(
                color = MaterialTheme.colorScheme.onBackground
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            lineLimits = TextFieldLineLimits.SingleLine,
            cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground),
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(
                    if (isFocused) {
                        MaterialTheme.colorScheme.primary.copy(
                            alpha = 0.05f
                        )
                    } else {
                        FoodWhiteColor
                    }
                )
                .border(
                    width = 1.dp,
                    color = if (isFocused) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        FoodBorderColor
                    },
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(14.dp)
                .onFocusChanged {
                    isFocused = it.isFocused
                },
            decorator = { innerBox ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (startIcon != null) {
                        Icon(
                            imageVector = startIcon,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                    Box(
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        if (value.isEmpty() && !isFocused) {
                            Text(
                                text = hint,
                                fontSize = 17.sp,
                                fontFamily = RobotoFontFamily(),
                                fontWeight = FontWeight.Normal,
                                color = FoodTextPrimaryColor,
//                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                        innerBox()
                    }
                    if (endIcon != null) {
                        Spacer(modifier = Modifier.width(10.dp))
                        Image(
                            painter = endIcon,
                            contentDescription = null,
                            modifier = Modifier
                                .size(width = 30.dp, 26.dp)
                        )
                    }
                }
            }

        )

//        BasicTextField2(
//            state = state,
//            textStyle = LocalTextStyle.current.copy(
//                color = MaterialTheme.colorScheme.onBackground
//            ),
//            keyboardOptions = KeyboardOptions(
//                keyboardType = keyboardType
//            ),
//            lineLimits = TextFieldLineLimits.SingleLine,
//            cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground),
//            modifier = Modifier
//                .clip(RoundedCornerShape(10.dp))
//                .background(
//                    if (isFocused) {
//                        MaterialTheme.colorScheme.primary.copy(
//                            alpha = 0.05f
//                        )
//                    } else {
//                        FoodWhiteColor
//                    }
//                )
//                .border(
//                    width = 1.dp,
//                    color = if (isFocused) {
//                        MaterialTheme.colorScheme.primary
//                    } else {
//                        FoodBorderColor
//                    },
//                    shape = RoundedCornerShape(10.dp)
//                )
//                .padding(14.dp)
//                .onFocusChanged {
//                    isFocused = it.isFocused
//                },
//            decorator = { innerBox ->
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    if (startIcon != null) {
//                        Icon(
//                            imageVector = startIcon,
//                            contentDescription = null,
//                            tint = MaterialTheme.colorScheme.onSurfaceVariant
//                        )
//                        Spacer(modifier = Modifier.width(16.dp))
//                    }
//                    Box(
//                        modifier = Modifier
//                            .weight(1f)
//                    ) {
//                        if (state.text.isEmpty() && !isFocused) {
//                            Text(
//                                text = hint,
//                                fontSize = 17.sp,
//                                fontFamily = RobotoFontFamily(),
//                                fontWeight = FontWeight.Normal,
//                                color = FoodTextPrimaryColor,
////                                modifier = Modifier.fillMaxWidth()
//                            )
//                        }
//                        innerBox()
//                    }
//                    if (endIcon != null) {
//                        Spacer(modifier = Modifier.width(10.dp))
//                        Image(
//                            painter = endIcon,
//                            contentDescription = null,
//                            modifier = Modifier
//                                .size(width = 30.dp, 26.dp)
//                        )
//                    }
//                }
//            }
//        )
    }
}