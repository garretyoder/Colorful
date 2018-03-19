package io.multimoon.colorful

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log


open class CAppCompatActivity:AppCompatActivity() {
    var themeString:String=""

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        themeString= Colorful().getThemeString()
        Colorful().apply(this,appcompat = true)
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