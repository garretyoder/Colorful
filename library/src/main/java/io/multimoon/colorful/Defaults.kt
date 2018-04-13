package io.multimoon.colorful

import android.support.annotation.StyleRes

data class Defaults(val primaryColor: ThemeColorInterface, val accentColor: ThemeColorInterface, val useDarkTheme: Boolean, val translucent: Boolean, @StyleRes val customTheme: Int = 0)