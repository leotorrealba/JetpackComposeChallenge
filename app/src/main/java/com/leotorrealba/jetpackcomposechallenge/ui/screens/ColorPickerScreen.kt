package com.leotorrealba.jetpackcomposechallenge.ui.screens


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.leotorrealba.jetpackcomposechallenge.ui.components.AppBar
import com.leotorrealba.jetpackcomposechallenge.ui.components.ColorPreview
import com.leotorrealba.jetpackcomposechallenge.ui.components.ColorSlider
import com.leotorrealba.jetpackcomposechallenge.ui.components.HexCodeDisplay
import com.leotorrealba.jetpackcomposechallenge.viewmodels.ColorPickerViewModel

@Composable
fun ColorPickerScreen(
    viewModel: ColorPickerViewModel = viewModel()
) {
    val colorState by viewModel.colorState
    val currentColor = Color(
        red = colorState.red,
        green = colorState.green,
        blue = colorState.blue
    )

    var isLoaded by remember { mutableStateOf(false) }

    androidx.compose.runtime.LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(100)
        isLoaded = true
    }

    Scaffold(
        topBar = { AppBar() }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = MaterialTheme.colorScheme.background
        ) {
            AnimatedVisibility(
                visible = isLoaded,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    ColorPreview(
                        color = currentColor,
                        hexCode = colorState.toHexString()
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    Divider()
                    Spacer(modifier = Modifier.height(16.dp))

                    ColorSlider(
                        value = colorState.red,
                        onValueChange = { viewModel.updateRed(it) },
                        label = "Red",
                        color = Color.Red
                    )

                    ColorSlider(
                        value = colorState.green,
                        onValueChange = { viewModel.updateGreen(it) },
                        label = "Green",
                        color = Color.Green
                    )

                    ColorSlider(
                        value = colorState.blue,
                        onValueChange = { viewModel.updateBlue(it) },
                        label = "Blue",
                        color = Color.Blue
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    HexCodeDisplay(
                        hexCode = colorState.toHexString(),
                        onCopyClick = viewModel::copyHexToClipboard
                    )
                }
            }
        }
    }
}