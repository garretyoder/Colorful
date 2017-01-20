package org.polaric.colorful;

import android.content.Context;
import android.support.annotation.StyleRes;
import android.util.Log;

public class ThemeDelegate {
    private Colorful.ThemeColor primaryColor;
    private Colorful.ThemeColor accentColor;
    private boolean translucent;
    private boolean dark;
    @StyleRes private int styleResPrimary;
    @StyleRes private int styleResAccent;
    @StyleRes private int styleResBase;

    ThemeDelegate(Context context, Colorful.ThemeColor primary, Colorful.ThemeColor accent, boolean translucent, boolean dark) {
        this.primaryColor=primary;
        this.accentColor=accent;
        this.translucent=translucent;
        this.dark=dark;
        long curTime = System.currentTimeMillis();
        styleResPrimary = context.getResources().getIdentifier("primary" + primary.ordinal(), "style", context.getPackageName());
        styleResAccent = context.getResources().getIdentifier("accent" + accent.ordinal(), "style", context.getPackageName());
        styleResBase = dark ? R.style.Colorful_Dark : R.style.Colorful_Light;
        Log.d(Util.LOG_TAG, "ThemeDelegate fetched theme in " + (System.currentTimeMillis()-curTime) + " milliseconds");
    }

    @StyleRes public int getStyleResPrimary() {
        return styleResPrimary;
    }

    @StyleRes public int getStyleResAccent() {
        return styleResAccent;
    }

    @StyleRes public int getStyleResBase() {
        return styleResBase;
    }

    public Colorful.ThemeColor getPrimaryColor() {
        return primaryColor;
    }

    public Colorful.ThemeColor getAccentColor() {
        return accentColor;
    }

    public boolean isTranslucent() {
        return translucent;
    }
    
    public boolean isDark() {
        return dark;
    }
}
