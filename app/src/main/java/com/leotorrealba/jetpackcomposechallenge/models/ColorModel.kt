package com.leotorrealba.jetpackcomposechallenge.models

data class ColorModel(
    val red: Int = 0,
    val green: Int = 0,
    val blue: Int = 0,
){
    fun toHexString(): String{
        return String.format("#%02X%02X%02X", red, green, blue)
    }
}
