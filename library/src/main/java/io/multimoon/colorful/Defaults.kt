package io.multimoon.colorful

import android.support.annotation.StyleRes

data class Defaults(val primaryColor: ThemeColor, val accentColor: ThemeColor, val useDarkTheme: Boolean, val translucent: Boolean, @StyleRes val customTheme: Int = 0)