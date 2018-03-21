package io.multimoon.colorful

import android.app.Activity
import android.app.ActivityManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.WindowManager

open class CActivity:Activity() {
    var themeString:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        themeString= Colorful().getThemeString()
        Colorful().apply(this)
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            if (Colorful().getTranslucent()) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            }
            setTaskDescription(ActivityManager.TaskDescription(null, null, Colorful().getPrimaryColor().getColorPack().dark().asInt()))
        }
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