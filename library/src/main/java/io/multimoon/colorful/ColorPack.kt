package io.multimoon.colorful

class ColorPack(internal val colorLight: ColorfulColor, internal val colorDark: ColorfulColor) {
    fun light() = colorLight
    fun dark() = colorDark
}