package com.leotorrealba.jetpackcomposechallenge.viewmodels

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.leotorrealba.jetpackcomposechallenge.models.ColorModel

class ColorPickerViewModel : ViewModel() {
    private val _colorState = mutableStateOf(ColorModel(red = 128, green = 128, blue = 128))
    val colorState: State<ColorModel> = _colorState

    fun updateRed(value: Int) {
        _colorState.value = _colorState.value.copy(red = value)
    }

    fun updateGreen(value: Int) {
        _colorState.value = _colorState.value.copy(green = value)
    }

    fun updateBlue(value: Int) {
        _colorState.value = _colorState.value.copy(blue = value)
    }

    fun copyHexToClipboard(context: Context) {
        val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("Color Hex Code", colorState.value.toHexString())
        clipboardManager.setPrimaryClip(clipData)

        Toast.makeText(context, "Hex code copied to clipboard", Toast.LENGTH_SHORT).show()
    }
}