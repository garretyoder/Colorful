package io.multimoon.colorful

class ColorPack (val colorLight:ColorfulColor, val colorDark:ColorfulColor) {
    fun light() = colorLight
    fun dark() = colorDark
}