package io.multimoon.colorful

import android.content.Context
import androidx.annotation.StyleRes
import android.util.Log

class ThemeEditor(internal var primaryColor: ThemeColorInterface = ThemeColor.INDIGO, internal var accentColor: ThemeColorInterface = ThemeColor.RED, internal var darkTheme: Boolean = true, internal var translucent: Boolean, internal @StyleRes var customTheme: Int = 0) {

    companion object {
        val PREF_NAME: String = "io.multimoon.colorful.colorvals"
    }

    fun setPrimaryColor(primaryColor: ThemeColorInterface): ThemeEditor {
        this.primaryColor = primaryColor
        return this
    }

    fun setAccentColor(accentColor: ThemeColorInterface): ThemeEditor {
        this.accentColor = accentColor
        return this
    }

    fun setDarkTheme(darkTheme: Boolean): ThemeEditor {
        this.darkTheme = darkTheme
        return this
    }

    fun setCustomThemeOverride(@StyleRes customTheme: Int): ThemeEditor {
        this.customTheme = customTheme
        return this
    }

    fun setTranslucent(translucent: Boolean): ThemeEditor {
        this.translucent = translucent
        return this
    }

    fun apply(context: Context, callback: () -> Unit = { Log.d("Colorful", "Callback omitted") }) {
        applyEdits(context, primaryColor, accentColor, darkTheme, translucent, customTheme)
        callback()
    }

    private fun applyEdits(context: Context, primaryColor: ThemeColorInterface, accentColor: ThemeColorInterface, darkTheme: Boolean, translucent: Boolean, customTheme: Int = 0) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        prefs.edit()
                .putBoolean(darkThemeKey, darkTheme)
                .putString(primaryThemeKey, primaryColor.themeName)
                .putString(accentThemeKey, accentColor.themeName)
                .putBoolean(translucentKey, translucent)
                .apply()
        if (customTheme != 0)
            prefs.edit().putInt(customThemeKey, customTheme).apply()
        else
            prefs.edit().remove(customThemeKey).apply()
        mInstance = ColorfulDelegate(primaryColor, accentColor, darkTheme, translucent)
    }

    fun resetPrefs(context: Context) {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit().clear().apply()
    }
}