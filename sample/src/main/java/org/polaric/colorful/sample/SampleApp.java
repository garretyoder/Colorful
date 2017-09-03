package org.polaric.colorful.sample;

import android.app.Application;
import android.graphics.Color;

import org.polaric.colorful.Colorful;

public class SampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Colorful.defaults()
                .primaryColor(Colorful.ThemeColor.RED)
                .accentColor(Colorful.ThemeColor.BLUE)
                .translucent(false)
                .dark(true);

        Colorful.init(this);
    }
}
