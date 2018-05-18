package io.multimoon.colorful

import android.app.Activity
import android.app.ActivityManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.WindowManager

interface CThemeInterface {
    var themeString: String

    fun handleOnCreate(activity: Activity, savedInstanceState: Bundle?, baseTheme: BaseTheme, override: Boolean = true) {
        themeString = Colorful().getThemeString()
        Log.d("COLORFUL", "Automatically applying theme (${themeString})")
        Colorful().apply(activity, baseTheme = baseTheme, override = override)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (Colorful().getTranslucent()) {
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            }
            activity.setTaskDescription(ActivityManager.TaskDescription(null, null, Colorful().getPrimaryColor().getColorPack().dark().asInt()))
        }
    }

    fun handleOnResume(activity: Activity) {
        if (!themeString.isBlank() && !themeString.equals(Colorful().getThemeString())) {
            themeString = Colorful().getThemeString()
            activity.recreate()
            Log.d("COLORFUL", "Theme change detected, reloading activity (${themeString})")
        }
    }
}