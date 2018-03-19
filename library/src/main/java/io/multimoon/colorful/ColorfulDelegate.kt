package io.multimoon.colorful

import android.app.Activity
import android.content.Context
import android.support.annotation.StyleRes
import android.util.Log

class ColorfulDelegate(var primaryColor:ThemeColor, var accentColor:ThemeColor, var darkTheme:Boolean,  @StyleRes val customTheme:Int=0) {

    fun apply(activity:Activity, override:Boolean = true, appcompat:Boolean = false) {
        if (appcompat) {
            if (override) activity.setTheme(if (darkTheme) R.style.Colorful_AppCompat_Dark else R.style.Colorful_AppCompat_Light)
            Log.d("COLORFUL","Using appcompat theme over native material per user preference")
        } else {
            if (override) activity.setTheme(if (darkTheme) R.style.Colorful_Dark else R.style.Colorful_Light)
        }
        activity.theme.applyStyle(primaryColor.primaryStyle(), true)
        activity.theme.applyStyle(accentColor.accentStyle(), true)
        if (customTheme!=0) {
            activity.theme.applyStyle(customTheme, true)
            Log.d("COLORFUL", "Overriding native colorful theme with user provided theme at StyleRes $customTheme")
        }
    }

    fun edit():ThemeEditor {
        return ThemeEditor(primaryColor, accentColor, darkTheme, customTheme)
    }

    fun clear(context: Context) {
        resetPrefs(context)
    }

    internal fun getThemeString():String {
        return primaryColor.name+":"+accentColor.name+":"+darkTheme+":"+customTheme
    }

}