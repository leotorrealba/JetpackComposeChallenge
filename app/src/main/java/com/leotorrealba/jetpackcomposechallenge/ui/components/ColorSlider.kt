package com.leotorrealba.jetpackcomposechallenge.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leotorrealba.jetpackcomposechallenge.ui.theme.JetpackComposeChallengeTheme


@Composable
fun ColorSlider(
    value: Int,
    onValueChange: (Int) -> Unit,
    label: String,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ){
        Text(
            text = "$label: $value"
        )
        Slider(
            value = value.toFloat(),
            onValueChange = {
                onValueChange(it.toInt())
            },
            valueRange = 0f..255f,
            modifier = Modifier
                .padding(8.dp)
        )

    }
}

@Preview (
    showBackground = true
)
@Composable
fun BasicModifierDemoPreview() {
    JetpackComposeChallengeTheme {
        ColorSlider(
            value = 100,
            onValueChange = {},
            label = "Red"
        )
    }
}