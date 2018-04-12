package io.multimoon.colorful

import android.support.annotation.StyleRes

enum class ThemeColor(private val primaryRes: Int, private val accentRes: Int, private val color: ColorPack) {
    RED(R.style.primary0, R.style.accent0, ColorPack(ColorfulColor("#f44336"), ColorfulColor("#d32f2f"))),
    PINK(R.style.primary1, R.style.accent1, ColorPack(ColorfulColor("#e91e63"), ColorfulColor("#c2185b"))),
    PURPLE(R.style.primary2, R.style.accent2, ColorPack(ColorfulColor("#9c27b0"), ColorfulColor("#7b1fa2"))),
    DEEP_PURPLE(R.style.primary3, R.style.accent3, ColorPack(ColorfulColor("#673ab7"), ColorfulColor("#512da8"))),
    INDIGO(R.style.primary4, R.style.accent4, ColorPack(ColorfulColor("#3f51b5"), ColorfulColor("#303f9f"))),
    BLUE(R.style.primary5, R.style.accent5, ColorPack(ColorfulColor("#2196f3"), ColorfulColor("#1976d2"))),
    LIGHT_BLUE(R.style.primary6, R.style.accent6, ColorPack(ColorfulColor("#03a9f4"), ColorfulColor("#0288d1"))),
    CYAN(R.style.primary7, R.style.accent7, ColorPack(ColorfulColor("#00bcd4"), ColorfulColor("#0097a7"))),
    TEAL(R.style.primary8, R.style.accent8, ColorPack(ColorfulColor("#009688"), ColorfulColor("#00796b"))),
    GREEN(R.style.primary9, R.style.accent9, ColorPack(ColorfulColor("#4caf50"), ColorfulColor("#388e3c"))),
    LIGHT_GREEN(R.style.primary10, R.style.accent10, ColorPack(ColorfulColor("#8bc34a"), ColorfulColor("#689f38"))),
    LIME(R.style.primary11, R.style.accent11, ColorPack(ColorfulColor("#cddc39"), ColorfulColor("#a4b42b"))),
    YELLOW(R.style.primary12, R.style.accent12, ColorPack(ColorfulColor("#ffeb3b"), ColorfulColor("#fbc02d"))),
    AMBER(R.style.primary13, R.style.accent13, ColorPack(ColorfulColor("#ffc107"), ColorfulColor("#ffa000"))),
    ORANGE(R.style.primary14, R.style.accent14, ColorPack(ColorfulColor("#ff9800"), ColorfulColor("#f57c00"))),
    DEEP_ORANGE(R.style.primary15, R.style.accent15, ColorPack(ColorfulColor("#ff5722"), ColorfulColor("#e64a19"))),
    BROWN(R.style.primary16, R.style.accent16, ColorPack(ColorfulColor("#795548"), ColorfulColor("#5d4037"))),
    GREY(R.style.primary17, R.style.accent17, ColorPack(ColorfulColor("#9e9e9e"), ColorfulColor("#616161"))),
    BLUE_GREY(R.style.primary18, R.style.accent18, ColorPack(ColorfulColor("#607d8b"), ColorfulColor("#455a64")));

    @StyleRes
    fun primaryStyle() = primaryRes

    @StyleRes
    fun accentStyle() = accentRes

    fun getColorPack() = color
}

