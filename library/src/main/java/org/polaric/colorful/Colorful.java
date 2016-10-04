package org.polaric.colorful;

import android.content.Context;
import android.preference.PreferenceManager;
import android.support.annotation.ColorRes;
import android.util.Log;

public class Colorful {
    private static ThemeDelegate delegate;
    private static ThemeColor primaryColor= ThemeColor.DEEP_PURPLE;
    private static ThemeColor accentColor= ThemeColor.RED;
    private static boolean isTranslucent=false;
    private static boolean isDark=false;
    private static String themeString;

    public static void init(Context context) {
        Log.d(Util.LOG_TAG,"Attatching to " + context.getPackageName());
        themeString=PreferenceManager.getDefaultSharedPreferences(context).getString(Util.PREFERENCE_KEY, null);
        if (themeString==null) {
            primaryColor=Default.primaryColor;
            accentColor=Default.accentColor;
            isTranslucent=Default.trans;
            isDark=Default.darkTheme;
            themeString=generateThemeString();
        }
        initValues();
        delegate = new ThemeDelegate(context, primaryColor, accentColor, isTranslucent, isDark);
    }

    private static void writeValues(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(Util.PREFERENCE_KEY, generateThemeString()).apply();
    }

    private static void initValues() {
        String [] colors = themeString.split(":");
        isDark = Boolean.parseBoolean(colors[0]);
        isTranslucent = Boolean.parseBoolean(colors[1]);
        primaryColor = Colorful.ThemeColor.values()[Integer.parseInt(colors[2])];
        accentColor = Colorful.ThemeColor.values()[Integer.parseInt(colors[3])];
    }

    private static String generateThemeString() {
        return isDark+ ":" + isTranslucent + ":" + primaryColor.ordinal() + ":" + accentColor.ordinal();
    }

    public static ThemeDelegate getThemeDelegate() {
        if (delegate==null) {
            Log.e(Util.LOG_TAG, "getThemeDelegate() called before init(Context). Call Colorful.init(Context) in your application class");
        }
        return delegate;
    }

    public enum ThemeColor {
        RED(R.color.md_red_500, R.color.md_red_700),
        PINK(R.color.md_pink_500, R.color.md_pink_700),
        PURPLE(R.color.md_purple_500, R.color.md_purple_700),
        DEEP_PURPLE(R.color.md_deep_purple_500, R.color.md_deep_purple_700),
        INDIGO(R.color.md_indigo_500, R.color.md_indigo_700),
        BLUE(R.color.md_blue_500, R.color.md_blue_700),
        LIGHT_BLUE(R.color.md_light_blue_500, R.color.md_light_blue_700),
        CYAN(R.color.md_cyan_500, R.color.md_cyan_700),
        TEAL(R.color.md_teal_500, R.color.md_teal_700),
        GREEN(R.color.md_green_500, R.color.md_green_700),
        LIGHT_GREEN(R.color.md_light_green_500, R.color.md_light_green_700),
        LIME(R.color.md_lime_500, R.color.md_lime_700),
        YELLOW(R.color.md_yellow_500, R.color.md_yellow_700),
        AMBER(R.color.md_amber_500, R.color.md_amber_700),
        ORANGE(R.color.md_orange_500, R.color.md_orange_700),
        DEEP_ORANGE(R.color.md_deep_orange_500, R.color.md_deep_orange_700);

        @ColorRes private int colorRes;
        @ColorRes private int darkColorRes;

        ThemeColor(@ColorRes int colorRes, @ColorRes int darkColorRes) {
            this.colorRes = colorRes;
            this.darkColorRes = darkColorRes;
        }

        public @ColorRes int getColorRes() {
            return colorRes;
        }

        public @ColorRes int getDarkColorRes() {
            return darkColorRes;
        }
    }

    public static class Default {

        private static ThemeColor primaryColor= ThemeColor.DEEP_PURPLE;
        private static ThemeColor accentColor= ThemeColor.RED;
        private static boolean trans=false;
        private static boolean darkTheme=false;

        public static void primaryColor(ThemeColor primary) {
            primaryColor = primary;
        }

        public static void accentColor(ThemeColor accent) {
            accentColor = accent;
        }

        public static void translucent(boolean translucent) {
            trans = translucent;
        }

        public static void dark(boolean dark) {
            darkTheme = dark;
        }
    }

    public static class Config {

        public static void primaryColor(ThemeColor primary) {
            primaryColor = primary;
        }

        public static void accentColor(ThemeColor accent) {
            accentColor = accent;
        }

        public static void translucent(boolean translucent) {
            isTranslucent = translucent;
        }

        public static void dark(boolean dark) {
            isDark = dark;
        }

        public static void apply(Context context) {
            writeValues(context);
            themeString=generateThemeString();
            delegate = new ThemeDelegate(context, primaryColor, accentColor, isTranslucent, isDark);
        }
    }

}
