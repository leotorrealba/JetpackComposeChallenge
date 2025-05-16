package com.leotorrealba.jetpackcomposechallenge.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.leotorrealba.jetpackcomposechallenge.ui.components.ColorPreview
import com.leotorrealba.jetpackcomposechallenge.ui.components.ColorSlider
import com.leotorrealba.jetpackcomposechallenge.ui.components.HexCodeDisplay
import com.leotorrealba.jetpackcomposechallenge.ui.theme.JetpackComposeChallengeTheme
import com.leotorrealba.jetpackcomposechallenge.viewmodels.ColorPickerViewModel

@Composable
fun ColorPickerScreen(
    viewModel: ColorPickerViewModel = viewModel()
){
    val colorState by viewModel.selectedColor
    val currentColor = Color(
        red = colorState.red,
        green = colorState.green,
        blue = colorState.blue
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            ColorPreview(color = currentColor)
            ColorSlider(
                value = colorState.red,
                onValueChange = viewModel::updateRed,
                label = "Red"
            )
            ColorSlider(
                value = colorState.green,
                onValueChange = viewModel::updateGreen,
                label = "Green"
            )
            ColorSlider(
                value = colorState.blue,
                onValueChange = viewModel::updateBlue,
                label = "Blue"
            )
            HexCodeDisplay(
                hexCode = colorState.toHexString(),
                onCopyClick = viewModel::copyHexToClipboard
            )
        }
    }

}

@Preview (
    showBackground = true
)
@Composable
fun BasicModifierDemoPreview() {
    JetpackComposeChallengeTheme {
        ColorPickerScreen()

    }
}