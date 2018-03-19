package io.multimoon.colorful

import android.graphics.Color

class ColorfulColor(internal val hexColor:String) {
    fun asHex() = hexColor
    fun asInt() = Color.parseColor(hexColor)
}