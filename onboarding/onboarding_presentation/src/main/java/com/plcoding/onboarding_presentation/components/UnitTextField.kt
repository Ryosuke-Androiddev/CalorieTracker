package com.plcoding.onboarding_presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import com.plcoding.core_ui.LocalSpacing

@Composable
fun UniteTextField(
    modifier: Modifier = Modifier,
    inputValue: String,
    onValueChange: (String) -> Unit,
    unit: String,
    textStyle: TextStyle = TextStyle(
        color = MaterialTheme.colors.primaryVariant,
        fontSize = 70.sp
    )
) {
    // check modifier width and alignBy
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        BasicTextField(
            modifier = modifier
                .width(IntrinsicSize.Min)
                .alignBy(LastBaseline),
            value = inputValue,
            onValueChange = onValueChange,
            textStyle = textStyle,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            singleLine = true
        )
        Spacer(modifier = Modifier.width(LocalSpacing.current.spaceSmall))
        Text(
            modifier = modifier.alignBy(LastBaseline),
            text = unit
        )
    }
}