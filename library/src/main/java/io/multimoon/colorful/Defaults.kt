package io.multimoon.colorful

import android.support.annotation.StyleRes

data class Defaults(val primaryColor:ThemeColor, val accentColor:ThemeColor, val useDarkTheme:Boolean, @StyleRes val customTheme:Int=0)