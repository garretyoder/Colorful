package org.polaric.colorful;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v7.preference.PreferenceManager;
import android.util.Log;

public class Colorful {
    private static ThemeDelegate delegate;
    private static ThemeColor primaryColor = Defaults.primaryColor;
    private static ThemeColor accentColor = Defaults.accentColor;
    private static boolean isTranslucent = Defaults.trans;
    private static boolean isDark = Defaults.darkTheme;
    private static String themeString;

    private Colorful() {
        // prevent initialization
    }

    public static void init(Context context) {
        Log.d(Util.LOG_TAG,"Attatching to " + context.getPackageName());
        themeString= PreferenceManager.getDefaultSharedPreferences(context).getString(Util.PREFERENCE_KEY, null);
        if (themeString == null) {
            primaryColor = Defaults.primaryColor;
            accentColor = Defaults.accentColor;
            isTranslucent = Defaults.trans;
            isDark = Defaults.darkTheme;
            themeString = generateThemeString();
        } else {
            initValues();
        }
        delegate = new ThemeDelegate(context, primaryColor, accentColor, isTranslucent, isDark);
    }

    public static void applyTheme(@NonNull Activity activity) {
        applyTheme(activity, true);
    }

    public static void applyTheme(@NonNull Activity activity, boolean overrideBase) {
        if (overrideBase) {
            activity.setTheme(getThemeDelegate().getStyleResBase());
        }
        activity.getTheme().applyStyle(getThemeDelegate().getStyleResPrimary(), true);
        activity.getTheme().applyStyle(getThemeDelegate().getStyleResAccent(), true);
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

    public static String getThemeString() {
        return themeString;
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
        DEEP_ORANGE(R.color.md_deep_orange_500, R.color.md_deep_orange_700),
        BROWN(R.color.md_brown_500, R.color.md_brown_700),
        GREY(R.color.md_grey_500, R.color.md_grey_700),
        BLUE_GREY(R.color.md_blue_grey_500, R.color.md_blue_grey_700),
        WHITE(R.color.md_white_1000, R.color.md_white_1000),
        BLACK(R.color.md_black_1000, R.color.md_black_1000);

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

    public static Config config(Context context) {
        return new Config(context);
    }

    public static Defaults defaults() {
        return new Defaults();
    }

    public static class Defaults {

        private static ThemeColor primaryColor= ThemeColor.DEEP_PURPLE;
        private static ThemeColor accentColor= ThemeColor.RED;
        private static boolean trans=false;
        private static boolean darkTheme=false;

        public Defaults primaryColor(ThemeColor primary) {
            primaryColor = primary;
            return this;
        }

        public Defaults accentColor(ThemeColor accent) {
            accentColor = accent;
            return this;
        }

        public Defaults translucent(boolean translucent) {
            trans = translucent;
            return this;
        }

        public Defaults dark(boolean dark) {
            darkTheme = dark;
            return this;
        }
    }

    public static class Config {
        private Context context;

        private Config(Context context) {
            this.context=context;
        }

        public Config primaryColor(ThemeColor primary) {
            primaryColor = primary;
            return this;
        }

        public Config accentColor(ThemeColor accent) {
            accentColor = accent;
            return this;
        }

        public Config translucent(boolean translucent) {
            isTranslucent = translucent;
            return this;
        }

        public Config dark(boolean dark) {
            isDark = dark;
            return this;
        }

        public void apply() {
            writeValues(context);
            themeString=generateThemeString();
            delegate = new ThemeDelegate(context, primaryColor, accentColor, isTranslucent, isDark);
        }
    }

}
