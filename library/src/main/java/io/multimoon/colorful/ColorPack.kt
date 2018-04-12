package io.multimoon.colorful

class ColorPack(internal val colorLight: ColorfulColor, internal val colorDark: ColorfulColor) {
    fun normal() = colorLight
    fun dark() = colorDark
}