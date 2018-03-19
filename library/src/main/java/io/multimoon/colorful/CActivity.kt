package io.multimoon.colorful

import android.app.Activity
import android.os.Bundle
import android.util.Log

open class CActivity:Activity() {
    var themeString:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        themeString= Colorful().getThemeString()
        Colorful().apply(this)
    }

    override fun onResume() {
        super.onResume()
        if (!themeString.isBlank() && !themeString.equals(Colorful().getThemeString())) {
            themeString= Colorful().getThemeString()
            recreate()
            Log.d("COLORFUL","Theme change detected, reloading activity")
        }
    }
}