package io.multimoon.colorful

class ColorPack(private val colorNormal: ColorfulColor, private val colorDark: ColorfulColor) {
    fun normal() = colorNormal
    fun dark() = colorDark
}