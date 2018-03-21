package io.multimoon.colorfulsample

import android.os.Bundle
import io.multimoon.colorful.CActivity
import io.multimoon.colorful.Colorful
import io.multimoon.colorful.ThemeColor

class MainActivity : CActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Colorful().edit()
                .setPrimaryColor(ThemeColor.RED)
                .setAccentColor(ThemeColor.BLUE)
                .setDarkTheme(true)
                .setTranslucent(true)
                .apply(this)
    }
}
