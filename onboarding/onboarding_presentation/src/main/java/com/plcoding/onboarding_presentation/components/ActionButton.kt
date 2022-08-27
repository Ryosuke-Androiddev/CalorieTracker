package com.plcoding.onboarding_presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.plcoding.core_ui.LocalSpacing

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String,
    isEnabled: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.button,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = isEnabled,
        shape = RoundedCornerShape(100.dp)
    ) {
        Text(
            modifier = Modifier.padding(LocalSpacing.current.spaceSmall),
            text = text,
            style = textStyle,
            color = MaterialTheme.colors.onPrimary
        )
    }
}