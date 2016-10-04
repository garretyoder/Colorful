package org.polaric.colorful;

import android.content.Context;
import android.support.annotation.StyleRes;
import android.util.Log;

public class ThemeDelegate {
    private Colorful.ThemeColor primaryColor;
    private Colorful.ThemeColor accentColor;
    private boolean translucent;
    private boolean dark;
    private int styleRes;

    ThemeDelegate(Context context, Colorful.ThemeColor primary, Colorful.ThemeColor accent, boolean translucent, boolean dark) {
        this.primaryColor=primary;
        this.accentColor=accent;
        this.translucent=translucent;
        this.dark=dark;
        long curTime = System.currentTimeMillis();
        styleRes = context.getResources().getIdentifier(
                (dark ? "DARK" : "LIGHT") +
                primaryColor.ordinal() +
                "T" +
                accentColor.ordinal(),
                "style", context.getPackageName());
        Log.d(Util.LOG_TAG, "ThemeDelegate fetched theme in " + (System.currentTimeMillis()-curTime) + " milliseconds");
    }

    public @StyleRes int getStyle() {
        return styleRes;
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
}
