package com.leotorrealba.jetpackcomposechallenge.viewmodels

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.ViewModel
import com.leotorrealba.jetpackcomposechallenge.models.ColorModel

class ColorPickerViewModel: ViewModel() {
    private val _selectedColor = mutableStateOf(ColorModel())
    val selectedColor: State<ColorModel> = _selectedColor

    fun updateRed(value: Int){
        _selectedColor.value = _selectedColor.value.copy(red = value)
    }

    fun updateGreen(value: Int){
        _selectedColor.value = _selectedColor.value.copy(green = value)
    }

    fun updateBlue(value: Int){
        _selectedColor.value = _selectedColor.value.copy(blue = value)
    }
    fun copyHexToClipboard(context: Context){
        val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("hexcode", selectedColor.value.toHexString())
        clipboardManager.setPrimaryClip(clipData)

    }
}